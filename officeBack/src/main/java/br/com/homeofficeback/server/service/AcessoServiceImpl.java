package br.com.homeofficeback.server.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.jose4j.jwt.GeneralJwtException;

import br.com.homeofficeback.dao.AcessoDao;
import br.com.homeofficeback.dao.CartelaDao;
import br.com.homeofficeback.dao.UsuarioDao;
import br.com.homeofficeback.entity.AcessoEntity;
import br.com.homeofficeback.entity.AcessoPkEntity;
import br.com.homeofficeback.entity.CartelaEntity;
import br.com.homeofficeback.entity.CartelaPkEntity;
import br.com.homeofficeback.entity.UsuarioEntity;
import br.com.homeofficeback.enuns.Status;
import br.com.homeofficeback.enuns.StatusAcesso;
import br.com.homeofficeback.enuns.TipoAcesso;
import br.com.homeofficeback.model.AcessoResult;
import br.com.homeofficeback.model.CadastrarAcesso;
import br.com.homeofficeback.model.PesquisaAcessoComercio;
import br.com.homeofficeback.util.HomeOfficeUtils;

@Stateless
public class AcessoServiceImpl {
	
	@EJB
	private AcessoDao dao;
	
	@EJB
	private CartelaDao cartelaDao;
	
	@EJB
	private UsuarioDao usuarioDao;
	
	public AcessoEntity findById(AcessoPkEntity id){
		return dao.find(id);
	}
	
	public AcessoPkEntity create(String userName, CadastrarAcesso cadastrarAcesso) throws GeneralJwtException{
		AcessoEntity entity = new AcessoEntity();
		
		UsuarioEntity user = usuarioDao.findByUserName(userName);
				
		entity.setUsuario(user);
		entity.setCoStatus(cadastrarAcesso.getCoStatus());
		entity.setCoTipoAcesso(cadastrarAcesso.getCoTipoAcesso());
		entity.setDtAcesso(cadastrarAcesso.getDtAcesso());
		entity.setId(new AcessoPkEntity(user.getId(), cadastrarAcesso.getComercio(), cadastrarAcesso.getDtAcesso()));
		
		if(entity.getDtAcesso()==null){
			entity.setDtAcesso(new Date());
		}
		
		verificarBaixaCartela(entity);
		
		return dao.save(entity);
	}
	
	
	public AcessoEntity update(String coStatus, AcessoPkEntity id) throws GeneralJwtException{
		AcessoEntity entity = findById(id);
		
		entity.setCoStatus(coStatus);

		verificarBaixaCartela(entity);

		entity = dao.merge(entity);
		
		return entity;
	}
	
	private void verificarBaixaCartela(AcessoEntity entity) throws GeneralJwtException{
		if(entity.getCoTipoAcesso()==TipoAcesso.CARTELA.value
				&& entity.getCoStatus().equals(StatusAcesso.CONCLUIDO.value)){
			efetuarBaixa(entity);
		}
	}
	
	private void efetuarBaixa(AcessoEntity acesso) throws GeneralJwtException{
		
		CartelaPkEntity id = new CartelaPkEntity(acesso.getId().getNuUsuario(), acesso.getId().getNuComercio());
		
		CartelaEntity entity = cartelaDao.find(id);
		
		if(entity.getQtLimiteAcessos()==entity.getQtAcesso()
				|| entity.getStatus() == Status.INATIVO.value){
			throw new GeneralJwtException("Cartela foi totalmente usada!");
		}
		
		Integer acessos = entity.getQtAcesso();
		
		entity.setQtAcesso(acessos+1);
		
		fecharCartela(entity);
		
		cartelaDao.merge(entity);
	}
	
	private void fecharCartela(CartelaEntity entity){
		
		if(entity.getQtLimiteAcessos()==entity.getQtAcesso()){
			entity.setStatus(Status.INATIVO.value);
		}
	}

	public List<AcessoResult> findByUsuarioAndComercio(String usuario, Integer comercio) {
		List<AcessoResult> results = new ArrayList<>();
		List<AcessoEntity> acessos = dao.findByUsuarioAndComercio(usuario, comercio);
		
		for (AcessoEntity acessoEntity : acessos) {
			AcessoResult acesso = new AcessoResult(); 
			
			HomeOfficeUtils.copyProperties(acesso, acessoEntity);
			HomeOfficeUtils.copyProperties(acesso, acessoEntity.getComercio());
			
			acesso.setIdComercio(acessoEntity.getId().getNuComercio());
			acesso.setIdUsuario(acessoEntity.getId().getNuUsuario());
		
			results.add(acesso);
		}
		
		return results;
	}
	
	public List<AcessoEntity> findByDateAndComercio(PesquisaAcessoComercio pesquisaAcessoComercio) {
		return dao.findByDateAndComercio(pesquisaAcessoComercio.getDataAcesso(), pesquisaAcessoComercio.getComercio());
	}

	public List<AcessoResult> findByUsuario(String username) {
		List<AcessoResult> results = new ArrayList<>();
		List<AcessoEntity> acessos = dao.findByUsuario(username);
		
		for (AcessoEntity acessoEntity : acessos) {
			AcessoResult acesso = new AcessoResult(); 
			
			HomeOfficeUtils.copyProperties(acesso, acessoEntity);
			HomeOfficeUtils.copyProperties(acesso, acessoEntity.getComercio());
			
			acesso.setIdComercio(acessoEntity.getId().getNuComercio());
			acesso.setIdUsuario(acessoEntity.getId().getNuUsuario());
			acesso.setCoStatus(acessoEntity.getCoStatus());
			results.add(acesso);
		}
		
		return results;
	}
	
}
