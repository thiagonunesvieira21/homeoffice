package br.com.homeofficeback.model;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

public class AlterarCartela implements Serializable{
	private static final long serialVersionUID = -3666961138134770469L;
	
	@NotNull
	private Integer qtLimiteAcessos, qtAcessoBonus;
	
	public AlterarCartela() {
		super();
	}

	public AlterarCartela(Integer qtLimiteAcessos, Integer qtAcessoBonus) {
		super();
		this.qtLimiteAcessos = qtLimiteAcessos;
		this.qtAcessoBonus = qtAcessoBonus;
	}

	public Integer getQtLimiteAcessos() {
		return qtLimiteAcessos;
	}

	public void setQtLimiteAcessos(Integer qtLimiteAcessos) {
		this.qtLimiteAcessos = qtLimiteAcessos;
	}

	public Integer getQtAcessoBonus() {
		return qtAcessoBonus;
	}

	public void setQtAcessoBonus(Integer qtAcessoBonus) {
		this.qtAcessoBonus = qtAcessoBonus;
	}
	
}
