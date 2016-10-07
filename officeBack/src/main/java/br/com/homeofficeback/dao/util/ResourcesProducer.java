package br.com.homeofficeback.dao.util;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@ApplicationScoped
public class ResourcesProducer {

	@Produces
	@PersistenceContext( unitName = "primary")
	private EntityManager entityManager;
}