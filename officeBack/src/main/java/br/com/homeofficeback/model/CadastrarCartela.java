package br.com.homeofficeback.model;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

public class CadastrarCartela implements Serializable {

	private static final long serialVersionUID = 63895048157998727L;

	@NotNull
	private Integer usuario, comercio, qtLimiteAcessos, qtAcessoBonus;

	public CadastrarCartela() {
		super();
	}

	public CadastrarCartela(Integer usuario, Integer comercio, Integer qtLimiteAcessos, Integer qtAcessoBonus) {
		super();
		this.usuario = usuario;
		this.comercio = comercio;
		this.qtLimiteAcessos = qtLimiteAcessos;
		this.qtAcessoBonus = qtAcessoBonus;
	}

	public Integer getUsuario() {
		return usuario;
	}

	public void setUsuario(Integer usuario) {
		this.usuario = usuario;
	}

	public Integer getComercio() {
		return comercio;
	}

	public void setComercio(Integer comercio) {
		this.comercio = comercio;
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
