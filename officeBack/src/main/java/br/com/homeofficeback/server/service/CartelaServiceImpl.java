package br.com.homeofficeback.server.service;

import java.util.Date;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.com.homeofficeback.dao.CartelaDao;
import br.com.homeofficeback.entity.CartelaEntity;
import br.com.homeofficeback.entity.CartelaPkEntity;
import br.com.homeofficeback.enuns.Status;
import br.com.homeofficeback.model.AlterarCartela;
import br.com.homeofficeback.model.CadastrarCartela;
import br.com.homeofficeback.util.HomeOfficeUtils;

@Stateless
public class CartelaServiceImpl {

	@EJB
	private CartelaDao dao;
	
	public CartelaEntity findById(CartelaPkEntity id){
		return dao.find(id);
	}
	
	public CartelaPkEntity create(CadastrarCartela cadastrarCartela){
		CartelaEntity entity = new CartelaEntity();
		
		HomeOfficeUtils.copyProperties(entity, cadastrarCartela);
		
		entity.setDhUltimaCarga(new Date(System.currentTimeMillis()));
		entity.setStatus(Status.ATIVO.value);
		entity.setQtAcesso(0);
		
		return dao.save(entity);
	}
	
	
	public CartelaEntity update(AlterarCartela alterarCartela, CartelaPkEntity id){
		CartelaEntity entity = dao.find(id);
		
		
		entity.setDhUltimaCarga(new Date(System.currentTimeMillis()));
		entity.setStatus(Status.ATIVO.value);
		
		if(entity.getQtLimiteAcessos()==entity.getQtAcesso()
				|| entity.getStatus() == Status.INATIVO.value){
			HomeOfficeUtils.copyProperties(entity, alterarCartela);
			entity.setQtAcesso(0);
		}else{
			
			Integer limite = entity.getQtLimiteAcessos() + alterarCartela.getQtLimiteAcessos();
			Integer bonus = entity.getQtAcessoBonus() + alterarCartela.getQtAcessoBonus();
			
			entity.setQtLimiteAcessos(limite);
			entity.setQtAcessoBonus(bonus);
		}
		
		return dao.merge(entity);
	}
}
