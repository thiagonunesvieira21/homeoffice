package br.com.homeofficeback.model;

import java.io.Serializable;

import javax.validation.constraints.Size;

public class PesquisarUsuario implements Serializable {

	private static final long serialVersionUID = 5351468227925616505L;

	@Size(max = 80)
	private String deLogin, deEmail;

	@Size(max = 60)
	private String noUsuario;

	public PesquisarUsuario(String deLogin, String deEmail, String noUsuario) {
		super();
		this.deLogin = deLogin;
		this.deEmail = deEmail;
		this.noUsuario = noUsuario;
	}

	public PesquisarUsuario() {
		super();
	}

	public String getDeLogin() {
		return deLogin;
	}

	public void setDeLogin(String deLogin) {
		this.deLogin = deLogin;
	}

	public String getDeEmail() {
		return deEmail;
	}

	public void setDeEmail(String deEmail) {
		this.deEmail = deEmail;
	}

	public String getNoUsuario() {
		return noUsuario;
	}

	public void setNoUsuario(String noUsuario) {
		this.noUsuario = noUsuario;
	}

}
