package br.com.homeofficeback.server.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.com.homeofficeback.dao.ComercioDao;
import br.com.homeofficeback.dao.GenericDaoJpaImpl.MatchMode;
import br.com.homeofficeback.dao.GenericDaoJpaImpl.MatchOperator;
import br.com.homeofficeback.dao.ProprietarioDao;
import br.com.homeofficeback.dao.UsuarioDao;
import br.com.homeofficeback.entity.ComercioEntity;
import br.com.homeofficeback.entity.ProprietarioEntity;
import br.com.homeofficeback.entity.ProprietarioPkEntity;
import br.com.homeofficeback.entity.UsuarioEntity;
import br.com.homeofficeback.enuns.Status;
import br.com.homeofficeback.model.CadastrarComercio;
import br.com.homeofficeback.model.PesquisarComercio;
import br.com.homeofficeback.util.HomeOfficeUtils;

@Stateless
public class ComercioServiceImpl {
	
	@EJB
	private ComercioDao dao;
	
	@EJB
	private UsuarioDao userDao;
	
	@EJB
	private ProprietarioDao proprietarioDao;
	
	public List<ComercioEntity> listAll(){
		return dao.findAll();
	}
	
	public ComercioEntity findById(Integer id){
		return dao.find(id);
	}
	
	public List<ComercioEntity> find(PesquisarComercio comercio){
		
		List<String> propertyNames, values;
		
		propertyNames = new ArrayList<>();
		values = new ArrayList<>();
		
		if(comercio.getNoFantazia()!=null && !comercio.getNoFantazia().isEmpty()){
			propertyNames.add("noFantazia");
			values.add(comercio.getNoFantazia());
		}
		
		if(comercio.getDeRazaoSocial()!=null && !comercio.getDeRazaoSocial().isEmpty()){
			propertyNames.add("deRazaoSocial");
			values.add(comercio.getDeRazaoSocial());
		}
		
		if(comercio.getNoCidade()!=null && !comercio.getNoCidade().isEmpty()){
			propertyNames.add("noCidade");
			values.add(comercio.getNoCidade());
		}
		
		return dao.findByProperty(MatchMode.ANYWHERE, MatchOperator.OR, propertyNames, values);
	}
	
	public Integer create(CadastrarComercio cadastrarComercio){
		ComercioEntity entity = new ComercioEntity();
		
		HomeOfficeUtils.copyProperties(entity, cadastrarComercio);
		
		prepareIncluirComercio(entity);
		
		dao.save(entity);
		
		UsuarioEntity usuario = new UsuarioEntity();
		
		HomeOfficeUtils.copyProperties(usuario, cadastrarComercio.getUsuario());
		
		usuario.setDeSenha(encodePassword(usuario.getDeSenha()));
		
		userDao.save(usuario);
		
		ProprietarioEntity proprietario = new ProprietarioEntity();
		proprietario.setComercio(entity);
		proprietario.setUsuario(usuario);
		proprietario.setId(new ProprietarioPkEntity(usuario.getId(), entity.getId()));
		
		proprietarioDao.save(proprietario);
		
		return entity.getId();
	}
	
	private void prepareIncluirComercio(ComercioEntity entity) {
		entity.setCoStatus(Status.ATIVO.value);
		entity.setDhInclusao(new Date(System.currentTimeMillis()));
		entity.setDhStatus(new Date(System.currentTimeMillis()));
	}

	public ComercioEntity update(CadastrarComercio cadastrarComercio, Integer id){
		ComercioEntity entity = dao.find(id);
		
		HomeOfficeUtils.copyProperties(entity, cadastrarComercio);
				
		return dao.merge(entity);
	}
	
	public void delete(Integer id){
		dao.delete(id);
	}
	
	private String encodePassword(String senha){
		return HomeOfficeUtils.getSHA1SecurePassword(senha);
	}
}
