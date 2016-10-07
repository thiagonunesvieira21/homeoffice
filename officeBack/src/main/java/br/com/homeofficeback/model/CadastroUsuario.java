package br.com.homeofficeback.model;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;

public class CadastroUsuario implements Serializable {

	private static final long serialVersionUID = 3719431980923835200L;

	private Integer nuDddTelefoneFixo, nuDddCelular, nuTelefoneFixo, nuCelular;

	@NotNull
	@ApiModelProperty(required = true)
	@Size(max = 60)
	private String noUsuario;

	@NotNull
	@ApiModelProperty(required = true)
	@Size(max = 80)
	private String deLogin, deEmail;

	@NotNull
	@ApiModelProperty(required = true)
	@Size(min = 11, max = 11)
	private String nuCpf;

	@NotNull
	@ApiModelProperty(required = true)
	@Size(min = 1, max = 1)
	private String coSexo;

	@NotNull
	@ApiModelProperty(required = true)
	@Size(min = 8, max = 16)
	private String deSenha;

	public CadastroUsuario() {
		super();
	}

	public CadastroUsuario(Integer nuDddTelefoneFixo, Integer nuDddCelular, Integer nuTelefoneFixo, Integer nuCelular,
			String noUsuario, String deLogin, String deEmail, String nuCpf, String coSexo, String deSenha) {
		super();
		this.nuDddTelefoneFixo = nuDddTelefoneFixo;
		this.nuDddCelular = nuDddCelular;
		this.nuTelefoneFixo = nuTelefoneFixo;
		this.nuCelular = nuCelular;
		this.noUsuario = noUsuario;
		this.deLogin = deLogin;
		this.deEmail = deEmail;
		this.nuCpf = nuCpf;
		this.coSexo = coSexo;
		this.deSenha = deSenha;
	}

	public String getNoUsuario() {
		return noUsuario;
	}

	public void setNoUsuario(String noUsuario) {
		this.noUsuario = noUsuario;
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

	public String getNuCpf() {
		return nuCpf;
	}

	public void setNuCpf(String nuCpf) {
		this.nuCpf = nuCpf;
	}

	public Integer getNuDddTelefoneFixo() {
		return nuDddTelefoneFixo;
	}

	public void setNuDddTelefoneFixo(Integer nuDddTelefoneFixo) {
		this.nuDddTelefoneFixo = nuDddTelefoneFixo;
	}

	public Integer getNuDddCelular() {
		return nuDddCelular;
	}

	public void setNuDddCelular(Integer nuDddCelular) {
		this.nuDddCelular = nuDddCelular;
	}

	public Integer getNuTelefoneFixo() {
		return nuTelefoneFixo;
	}

	public void setNuTelefoneFixo(Integer nuTelefoneFixo) {
		this.nuTelefoneFixo = nuTelefoneFixo;
	}

	public Integer getNuCelular() {
		return nuCelular;
	}

	public void setNuCelular(Integer nuCelular) {
		this.nuCelular = nuCelular;
	}

	public String getCoSexo() {
		return coSexo;
	}

	public void setCoSexo(String coSexo) {
		this.coSexo = coSexo;
	}

	public String getDeSenha() {
		return deSenha;
	}

	public void setDeSenha(String deSenha) {
		this.deSenha = deSenha;
	}

}
