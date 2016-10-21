package br.com.homeofficeback.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.ws.rs.NotFoundException;

import br.com.homeofficeback.dao.util.Order;
import br.com.homeofficeback.entity.BaseEntity;

public class GenericDaoJpaImpl<T extends BaseEntity<PK>, PK extends Serializable> implements GenericDao<T, PK> {
	
	/*
	 * A "copy" of the Hibernate's API as this doesn't exist
	 * in JPA.
	 */
	public enum MatchMode { START, END, EXACT, ANYWHERE }

	public enum MatchOperator { AND, OR }
	
	protected Class<T> clazz;
	
	@Inject
	protected EntityManager entityManager;

	@SuppressWarnings("unchecked")
	public GenericDaoJpaImpl() {
		if(getClass().getSuperclass().getGenericSuperclass() instanceof ParameterizedType){
	        ParameterizedType genericSuperclass = (ParameterizedType) getClass().getSuperclass().getGenericSuperclass();
	        this.clazz = (Class<T>) genericSuperclass.getActualTypeArguments()[0];
		}else if(getClass().getGenericSuperclass() instanceof ParameterizedType){
			ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
	        this.clazz = (Class<T>) genericSuperclass.getActualTypeArguments()[0];
		}
    }
	
	/**
	 * Saves an entity.
	 * 
	 * @param entity
	 * @return newly created id for the entity.
	 */
	public PK save(T entity) {
		entityManager.persist(entity);
		return entity.getId();
	}


	/**
	 * Marges objects with the same identifier within a session into a newly
	 * created object.
	 * 
	 * @param entity
	 * @return a newly created instance merged.
	 */
	public T merge(T entity) {
		return entityManager.merge(entity);
	}

	/**
	 * Deletes tne entity.
	 * 
	 * @param clazz
	 * @param id
	 * @throws NotFoundException if the id does not exist.
	 */
	public void delete(PK id) {
		T entity = find(id);
		if (entity != null) {
			entityManager.remove(entity);
		} else {
			throw new NotFoundException();
		}
	}

	/**
	 * Find an entity by its identifier.
	 * 
	 * @param clazz
	 * @param id
	 * @return
	 */
	public T find(Serializable id) {
		return entityManager.find(clazz, id);
	}

	/**
	 * Finds an entity by one of its properties.
	 * 
	 * 
	 * @param clazz the entity class.
	 * @param propertyName the property name.
	 * @param value the value by which to find.
	 * @return
	 */
	public List<T> findByProperty(String propertyName, Object value) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<T> cq = cb.createQuery(clazz);
		Root<T> root = cq.from(clazz);
		cq.where(cb.equal(root.get(propertyName), value));
		return entityManager.createQuery(cq).getResultList();
	}
	
	/**
	 * Finds entities by a String property specifying a MatchMode. This search 
	 * is case insensitive.
	 * 
	 * @param clazz the entity class.
	 * @param propertyName the property name.
	 * @param value the value to check against.
	 * @param matchMode the match mode: EXACT, START, END, ANYWHERE.
	 * @return
	 */
	public List<T> findByProperty(String propertyName, String value, MatchMode matchMode) {
		//convert the value String to lowercase
		value = value.toLowerCase();
		if (MatchMode.START.equals(matchMode)) {
			value = value + "%";
		} else if (MatchMode.END.equals(matchMode)) {
			value = "%" + value;
		} else if (MatchMode.ANYWHERE.equals(matchMode)) {
			value = "%" + value + "%";
		}
		
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<T> cq = cb.createQuery(clazz);
		cq.where(cb.like(cb.lower(cb.literal(propertyName)), value));
		
		return entityManager.createQuery(cq).getResultList();
	}
	
	
	/**
	 * Finds entities by a String propertys specifying a MatchMode. This search 
	 * is case insensitive.
	 * 
	 * @param clazz the entity class.
	 * @param propertyNames list the property name.
	 * @param value the value to check against.
	 * @param matchMode the match mode: EXACT, START, END, ANYWHERE.
	 * @param MatchOperator the match operator mode: AND, OR.
	 * @return
	 */
	public List<T> findByProperty(MatchMode matchMode, MatchOperator matchOperator, List<String> propertyNames,  List<String> values) {
		
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<T> cq = cb.createQuery(clazz);
		cq.from(clazz);
		cq.where(cb.isNotNull(cb.literal("id")));

		//convert the value String to lowercase

		for(int i=0; i<propertyNames.size(); i++){
			String propertyName = propertyNames.get(i);
			String value = values.get(i);
			
			value = value.toLowerCase();
			if (MatchMode.START.equals(matchMode)) {
				value = value + "%";
			} else if (MatchMode.END.equals(matchMode)) {
				value = "%" + value;
			} else if (MatchMode.ANYWHERE.equals(matchMode)) {
				value = "%" + value + "%";
			}
			
			if (MatchOperator.AND.equals(matchOperator) || i==0) {
				cb.and(cb.like(cb.lower(cb.literal(propertyName)), value));
			} else if (MatchOperator.OR.equals(matchOperator)) {
				cb.or(cb.like(cb.lower(cb.literal(propertyName)), value));	
			}
		}
		
		return entityManager.createQuery(cq).getResultList();
	}
	

	/**
	 * Finds all objects of an entity class.
	 * 
	 * @param clazz the entity class.
	 * @return
	 */
	public List<T> findAll() {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<T> cq = cb.createQuery(clazz);
		cq.from(clazz);
		return entityManager.createQuery(cq).getResultList();
	}

	/**
	 * Finds all objects of a class by the specified order.
	 * 
	 * @param clazz the entity class.
	 * @param order the order: ASC or DESC.
	 * @param propertiesOrder the properties on which to apply the ordering.
	 * 
	 * @return
	 */
	public List<T> findAll(Order order, String... propertiesOrder) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<T> cq = cb.createQuery(clazz);
		Root<T> root = cq.from(clazz);
		
		List<javax.persistence.criteria.Order> orders = new ArrayList<>();
		for (String propertyOrder : propertiesOrder) {
			if (order.isAscOrder()) {
				orders.add(cb.asc(root.get(propertyOrder)));
			} else {
				orders.add(cb.desc(root.get(propertyOrder)));
			}
		}
		cq.orderBy(orders);

		return entityManager.createQuery(cq).getResultList();
	}
}
