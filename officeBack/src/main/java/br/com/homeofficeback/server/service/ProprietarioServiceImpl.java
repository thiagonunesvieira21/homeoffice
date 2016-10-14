package br.com.homeofficeback.server.service;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.com.homeofficeback.dao.ComercioDao;
import br.com.homeofficeback.dao.ProprietarioDao;
import br.com.homeofficeback.dao.UsuarioDao;
import br.com.homeofficeback.entity.ComercioEntity;
import br.com.homeofficeback.entity.ProprietarioEntity;
import br.com.homeofficeback.entity.ProprietarioPkEntity;
import br.com.homeofficeback.entity.UsuarioEntity;
import br.com.homeofficeback.model.CadastroUsuario;
import br.com.homeofficeback.util.HomeOfficeUtils;

@Stateless
public class ProprietarioServiceImpl {

	@EJB
	private ProprietarioDao dao;
	
	@EJB
	private ComercioDao comercioDao;
	
	@EJB
	private UsuarioDao userDao;
	
	public ProprietarioPkEntity create(CadastroUsuario usuario, Integer idComercio){
		UsuarioEntity entity = new UsuarioEntity();
		
		HomeOfficeUtils.copyProperties(entity, usuario);
		
		userDao.save(entity);
		
		ComercioEntity comercio = comercioDao.find(idComercio);
		
		ProprietarioEntity proprietario = new ProprietarioEntity();
		proprietario.setComercio(comercio);
		proprietario.setUsuario(entity);
		proprietario.setId(new ProprietarioPkEntity(entity.getId(), comercio.getId()));
		
	
		return dao.save(proprietario);
	}
	
}
