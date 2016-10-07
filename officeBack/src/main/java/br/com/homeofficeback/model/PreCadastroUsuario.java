package br.com.homeofficeback.model;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;

public class PreCadastroUsuario implements Serializable {

	private static final long serialVersionUID = 6510700397817443395L;

	@NotNull
	@ApiModelProperty(required = true)
	@Size(max = 80)
	private String deLogin, deEmail;

	@NotNull
	@ApiModelProperty(required = true)
	@Size(min = 8, max = 16)
	private String deSenha;

	public PreCadastroUsuario() {
		super();
	}

	public PreCadastroUsuario(String deLogin, String deEmail, String deSenha) {
		super();
		this.deLogin = deLogin;
		this.deEmail = deEmail;
		this.deSenha = deSenha;
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

	public String getDeSenha() {
		return deSenha;
	}

	public void setDeSenha(String deSenha) {
		this.deSenha = deSenha;
	}

}
