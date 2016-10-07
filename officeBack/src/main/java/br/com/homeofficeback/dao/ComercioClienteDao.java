package br.com.homeofficeback.dao;

import javax.ejb.Stateless;

import br.com.homeofficeback.entity.ComercioClienteEntity;
import br.com.homeofficeback.entity.ComercioClientePkEntity;

@Stateless
public class ComercioClienteDao extends GenericDaoJpaImpl<ComercioClienteEntity, ComercioClientePkEntity> {

}
