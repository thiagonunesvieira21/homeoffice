package br.com.homeofficeback.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import br.com.homeofficeback.entity.AcessoEntity;
import br.com.homeofficeback.entity.AcessoPkEntity;

@Stateless
public class AcessoDao extends GenericDaoJpaImpl<AcessoEntity, AcessoPkEntity> {

	public List<AcessoEntity> findByUsuarioAndComercio(String usuario, Integer comercio) {
		List<javax.persistence.criteria.Order> orders = new ArrayList<>();
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<AcessoEntity> cq = cb.createQuery(AcessoEntity.class);
		Root<AcessoEntity> root = cq.from(AcessoEntity.class);
		cq.where(cb.and(cb.equal(root.get("comercio").get("id"), comercio),
				cb.equal(root.get("usuario").get("deLogin"), usuario)));

		orders.add(cb.desc(root.get("dtAcesso")));
		cq.orderBy(orders);

		return entityManager.createQuery(cq).getResultList();
	}

	public List<AcessoEntity> findByDateAndComercio(Date date, Integer comercio) {

		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<AcessoEntity> cq = cb.createQuery(AcessoEntity.class);
		Root<AcessoEntity> root = cq.from(AcessoEntity.class);
		cq.where(cb.and(cb.equal(root.get("comercio").get("id"), comercio), cb.equal(root.get("dtAcesso"), date)));

		return entityManager.createQuery(cq).getResultList();
	}

}
