package br.com.homeofficeback.model;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CadastrarAcesso implements Serializable {

	private static final long serialVersionUID = -3798728554988035432L;

	@NotNull
	private Integer comercio;

	private Integer usuario; 

	@NotNull
	private Date dtAcesso;

	@NotNull
	@Size(max = 1)
	private String coTipoAcesso;
	
	@NotNull
	@Size(max = 1)
	private String coStatus;

	public CadastrarAcesso() {
		super();
	}

	public CadastrarAcesso(Integer usuario, Integer comercio, Date dtAcesso, String coTipoAcesso, String coStatus) {
		super();
		this.usuario = usuario;
		this.comercio = comercio;
		this.dtAcesso = dtAcesso;
		this.coTipoAcesso = coTipoAcesso;
		this.coStatus = coStatus;
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

	public Date getDtAcesso() {
		return dtAcesso;
	}

	public void setDtAcesso(Date dtAcesso) {
		this.dtAcesso = dtAcesso;
	}

	public String getCoTipoAcesso() {
		return coTipoAcesso;
	}

	public void setCoTipoAcesso(String coTipoAcesso) {
		this.coTipoAcesso = coTipoAcesso;
	}

	public String getCoStatus() {
		return coStatus;
	}

	public void setCoStatus(String coStatus) {
		this.coStatus = coStatus;
	}

}
