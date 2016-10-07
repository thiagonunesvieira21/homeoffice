package br.com.homeofficeback.server.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.com.homeofficeback.dao.ComercioClienteDao;
import br.com.homeofficeback.dao.ComercioDao;
import br.com.homeofficeback.dao.GenericDaoJpaImpl.MatchMode;
import br.com.homeofficeback.dao.GenericDaoJpaImpl.MatchOperator;
import br.com.homeofficeback.dao.UsuarioDao;
import br.com.homeofficeback.entity.ComercioClienteEntity;
import br.com.homeofficeback.entity.ComercioClientePkEntity;
import br.com.homeofficeback.entity.ComercioEntity;
import br.com.homeofficeback.entity.UsuarioEntity;
import br.com.homeofficeback.enuns.Status;
import br.com.homeofficeback.model.CadastroUsuario;
import br.com.homeofficeback.model.PesquisarUsuario;
import br.com.homeofficeback.util.HomeOfficeUtils;

@Stateless
public class UsuarioServiceImpl {
		
	@EJB
	private UsuarioDao dao;
	
	@EJB
	private ComercioDao comercioDao;
	
	@EJB
	private ComercioClienteDao comercioClienteDao;

	public List<UsuarioEntity> listAll(){
		return dao.findAll();
	}
	
	public UsuarioEntity findById(Integer id){
		return dao.find(id);
	}
	
	public List<UsuarioEntity> find(PesquisarUsuario usuario){
		
		List<String> propertyNames, values;
		
		propertyNames = new ArrayList<>();
		values = new ArrayList<>();
		
		if(usuario.getDeEmail()!=null && !usuario.getDeEmail().isEmpty()){
			propertyNames.add("deEmail");
			values.add(usuario.getDeEmail());
		}
		
		if(usuario.getNoUsuario()!=null && !usuario.getNoUsuario().isEmpty()){
			propertyNames.add("noUsuario");
			values.add(usuario.getNoUsuario());
		}
		
		if(usuario.getDeLogin()!=null && !usuario.getDeLogin().isEmpty()){
			propertyNames.add("deLogin");
			values.add(usuario.getDeLogin());
		}
		
		return dao.findByProperty(MatchMode.ANYWHERE, MatchOperator.OR, propertyNames, values);
	}
	
	public Integer create(CadastroUsuario cadastroUsuario){
		UsuarioEntity entity = new UsuarioEntity();
		
		HomeOfficeUtils.copyProperties(entity, cadastroUsuario);
		
		encrypter(entity);
		
		prepareIncluirUsuario(entity);
		
		return dao.save(entity);
	}

	private void encrypter(UsuarioEntity entity) {
		entity.setDeSenha(encodePassword(entity.getDeSenha()));
	}
	
	private void prepareIncluirUsuario(UsuarioEntity entity) {
		entity.setCoStatus(Status.ATIVO.value);
		entity.setDhInclusao(new Date(System.currentTimeMillis()));
		entity.setDhStatus(new Date(System.currentTimeMillis()));
	}

	public UsuarioEntity update(CadastroUsuario cadastroUsuario, Integer id){
		UsuarioEntity entity = dao.find(id);
		
		HomeOfficeUtils.copyProperties(entity, cadastroUsuario);
		
		encrypter(entity);
		
		return dao.merge(entity);
	}
	
	public void delete(Integer id){
		dao.delete(id);
	}
	
	public ComercioClientePkEntity vincularAoComercio(String userName, Integer idComercio){
		ComercioClienteEntity entity = new ComercioClienteEntity();
		
		ComercioEntity comercio = comercioDao.find(idComercio);
		entity.setComercio(comercio);
		
		UsuarioEntity usuario = dao.findByUserName(userName);
		entity.setUsuario(usuario);
		
		Date dtVinculo = new Date(System.currentTimeMillis());
		entity.setDtVinculo(dtVinculo);
		
		entity.setId(new ComercioClientePkEntity(usuario.getId(), comercio.getId(), dtVinculo));
		
		return comercioClienteDao.save(entity);
	}
	
	public UsuarioEntity doLogin(String login, String senha) {
		UsuarioEntity usuario = dao.findByLoginAndSenha(login, encodePassword(senha));
		if(usuario == null) {
			return null;
		}
		return usuario;
	}
	
	public UsuarioEntity findByUserName(String userName){
		return dao.findByUserName(userName);
	}
	
	private String encodePassword(String senha){
		return HomeOfficeUtils.getSHA1SecurePassword(senha);
	}
}
