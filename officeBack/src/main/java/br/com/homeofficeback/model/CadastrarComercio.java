package br.com.homeofficeback.model;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;

public class CadastrarComercio implements Serializable {

	private static final long serialVersionUID = 5518860630369270624L;

	@NotNull
	@ApiModelProperty(required = true)
	@Size(max = 60)
	private String deRazaoSocial, noFantazia, noCidade;

	@NotNull
	@ApiModelProperty(required = true)
	@Size(min = 1, max = 1)
	private String coTipoDocumento;

	@NotNull
	@ApiModelProperty(required = true)
	@Size(min = 11, max = 16)
	private String deDocumento;

	@NotNull
	@ApiModelProperty(required = true)
	@Size(min = 8, max = 8)
	private String noCep;

	@Size(max = 255)
	private String deLocalizacao;

	@Size(max = 60)
	private String noBairro, deLogradouro, deCoplementoLogradouro;

	@Size(max = 8)
	private String nuLogradouro;

	@NotNull
	@ApiModelProperty(required = true)
	@Size(max = 3)
	private Integer nuDddTelefoneFixo;

	@NotNull
	@ApiModelProperty(required = true)
	@Size(max = 9)
	private Integer nuTelefoneFixo;

	@Size(max = 3)
	private Integer nuDddCelular;

	@Size(max = 9)
	private Integer nuCelular;

	@NotNull
	@ApiModelProperty(required = true)
	@Size(max = 80)
	private String deEmail;
	
	private CadastroUsuario usuario;

	public CadastrarComercio() {
		super();
	}

	public CadastrarComercio(String deRazaoSocial, String noFantazia, String noCidade, String coTipoDocumento,
			String deDocumento, String noCep, String deLocalizacao, String noBairro, String deLogradouro,
			String deCoplementoLogradouro, String nuLogradouro, Integer nuDddTelefoneFixo, Integer nuTelefoneFixo,
			Integer nuDddCelular, Integer nuCelular, String deEmail, CadastroUsuario usuario) {
		super();
		this.deRazaoSocial = deRazaoSocial;
		this.noFantazia = noFantazia;
		this.noCidade = noCidade;
		this.coTipoDocumento = coTipoDocumento;
		this.deDocumento = deDocumento;
		this.noCep = noCep;
		this.deLocalizacao = deLocalizacao;
		this.noBairro = noBairro;
		this.deLogradouro = deLogradouro;
		this.deCoplementoLogradouro = deCoplementoLogradouro;
		this.nuLogradouro = nuLogradouro;
		this.nuDddTelefoneFixo = nuDddTelefoneFixo;
		this.nuTelefoneFixo = nuTelefoneFixo;
		this.nuDddCelular = nuDddCelular;
		this.nuCelular = nuCelular;
		this.deEmail = deEmail;
		this.usuario = usuario;
	}

	public String getDeRazaoSocial() {
		return deRazaoSocial;
	}

	public void setDeRazaoSocial(String deRazaoSocial) {
		this.deRazaoSocial = deRazaoSocial;
	}

	public String getNoFantazia() {
		return noFantazia;
	}

	public void setNoFantazia(String noFantazia) {
		this.noFantazia = noFantazia;
	}

	public String getNoCidade() {
		return noCidade;
	}

	public void setNoCidade(String noCidade) {
		this.noCidade = noCidade;
	}

	public String getCoTipoDocumento() {
		return coTipoDocumento;
	}

	public void setCoTipoDocumento(String coTipoDocumento) {
		this.coTipoDocumento = coTipoDocumento;
	}

	public String getDeDocumento() {
		return deDocumento;
	}

	public void setDeDocumento(String deDocumento) {
		this.deDocumento = deDocumento;
	}

	public String getNoCep() {
		return noCep;
	}

	public void setNoCep(String noCep) {
		this.noCep = noCep;
	}

	public String getDeLocalizacao() {
		return deLocalizacao;
	}

	public void setDeLocalizacao(String deLocalizacao) {
		this.deLocalizacao = deLocalizacao;
	}

	public String getNoBairro() {
		return noBairro;
	}

	public void setNoBairro(String noBairro) {
		this.noBairro = noBairro;
	}

	public String getDeLogradouro() {
		return deLogradouro;
	}

	public void setDeLogradouro(String deLogradouro) {
		this.deLogradouro = deLogradouro;
	}

	public String getDeCoplementoLogradouro() {
		return deCoplementoLogradouro;
	}

	public void setDeCoplementoLogradouro(String deCoplementoLogradouro) {
		this.deCoplementoLogradouro = deCoplementoLogradouro;
	}

	public String getNuLogradouro() {
		return nuLogradouro;
	}

	public void setNuLogradouro(String nuLogradouro) {
		this.nuLogradouro = nuLogradouro;
	}

	public Integer getNuDddTelefoneFixo() {
		return nuDddTelefoneFixo;
	}

	public void setNuDddTelefoneFixo(Integer nuDddTelefoneFixo) {
		this.nuDddTelefoneFixo = nuDddTelefoneFixo;
	}

	public Integer getNuTelefoneFixo() {
		return nuTelefoneFixo;
	}

	public void setNuTelefoneFixo(Integer nuTelefoneFixo) {
		this.nuTelefoneFixo = nuTelefoneFixo;
	}

	public Integer getNuDddCelular() {
		return nuDddCelular;
	}

	public void setNuDddCelular(Integer nuDddCelular) {
		this.nuDddCelular = nuDddCelular;
	}

	public Integer getNuCelular() {
		return nuCelular;
	}

	public void setNuCelular(Integer nuCelular) {
		this.nuCelular = nuCelular;
	}

	public String getDeEmail() {
		return deEmail;
	}

	public void setDeEmail(String deEmail) {
		this.deEmail = deEmail;
	}

	public CadastroUsuario getUsuario() {
		return usuario;
	}

	public void setUsuario(CadastroUsuario usuario) {
		this.usuario = usuario;
	}

}
