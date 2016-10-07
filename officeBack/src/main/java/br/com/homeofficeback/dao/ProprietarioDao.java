package br.com.homeofficeback.dao;

import javax.ejb.Stateless;

import br.com.homeofficeback.entity.ProprietarioEntity;
import br.com.homeofficeback.entity.ProprietarioPkEntity;

@Stateless
public class ProprietarioDao extends GenericDaoJpaImpl<ProprietarioEntity, ProprietarioPkEntity> {

}
