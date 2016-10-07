package br.com.homeofficeback.model;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;

public class PesquisaAcessoComercio implements Serializable {
	private static final long serialVersionUID = 1L;

	@NotNull
	private Date dataAcesso;

	@NotNull
	private Integer comercio;
	
	public PesquisaAcessoComercio() {
		super();
	}

	public PesquisaAcessoComercio(Date dataAcesso, Integer comercio) {
		super();
		this.dataAcesso = dataAcesso;
		this.comercio = comercio;
	}

	public Date getDataAcesso() {
		return dataAcesso;
	}

	public void setDataAcesso(Date dataAcesso) {
		this.dataAcesso = dataAcesso;
	}

	public Integer getComercio() {
		return comercio;
	}

	public void setComercio(Integer comercio) {
		this.comercio = comercio;
	}

}
