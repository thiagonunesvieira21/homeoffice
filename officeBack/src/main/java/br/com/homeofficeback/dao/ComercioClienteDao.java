package br.com.homeofficeback.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import br.com.homeofficeback.entity.ComercioClienteEntity;
import br.com.homeofficeback.entity.ComercioClientePkEntity;

@Stateless
public class ComercioClienteDao extends GenericDaoJpaImpl<ComercioClienteEntity, ComercioClientePkEntity> {

	public List<ComercioClienteEntity> findByUserId(Integer id) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<ComercioClienteEntity> cq = cb.createQuery(ComercioClienteEntity.class);
		Root<ComercioClienteEntity> root = cq.from(ComercioClienteEntity.class);
		cq.where(cb.equal(root.get("nuUsuario"), id));

		return entityManager.createQuery(cq).getResultList();
	}

}
