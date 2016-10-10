package br.com.homeofficeback.dao;

import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import br.com.homeofficeback.entity.UsuarioEntity;

@Stateless
public class UsuarioDao extends GenericDaoJpaImpl<UsuarioEntity, Integer> {

	public UsuarioEntity findByUserName(String userName) {
		try {
			CriteriaBuilder cb = entityManager.getCriteriaBuilder();
			CriteriaQuery<UsuarioEntity> cq = cb.createQuery(UsuarioEntity.class);
			Root<UsuarioEntity> root = cq.from(UsuarioEntity.class);
			cq.where(cb.equal(root.get("deLogin"), userName));

			return entityManager.createQuery(cq).getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	public UsuarioEntity findByLoginAndSenha(String login, String senha) {
		try {
			CriteriaBuilder cb = entityManager.getCriteriaBuilder();
			CriteriaQuery<UsuarioEntity> cq = cb.createQuery(UsuarioEntity.class);
			Root<UsuarioEntity> root = cq.from(UsuarioEntity.class);

			Predicate p1 = cb.and(cb.equal(root.get("deLogin"), login));
			Predicate p2 = cb.and(cb.equal(root.get("deSenha"), senha));
			
			cq.where(p1, p2);
			
			return entityManager.createQuery(cq).getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

}
