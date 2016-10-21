package br.com.homeofficeback.model;

import java.io.Serializable;
import java.util.Date;

public class AcessoResult implements Serializable {

	private static final long serialVersionUID = -2387604251380633997L;
	
	private Date dtAcesso;
	private String coStatus;
	private String coTipoAcesso;
	private Integer idComercio;
	private Integer idUsuario;
	private String deRazaoSocial;
	private String noFantazia;
	private String noCep;
	private String deLocalizacao;
	private String noBairro;
	private String noCidade;
	private String deLogradouro;
	private String nuLogradouro;
	private String deCoplementoLogradouro;
	private Integer nuDddTelefoneFixo;
	private Integer nuTelefoneFixo;
	private Integer nuDddCelular;
	private Integer nuCelular;
	private String deEmail;
	
	public AcessoResult() {
		super();
	}
	
	public AcessoResult(Date dtAcesso, String coStatus, String coTipoAcesso) {
		super();
		this.dtAcesso = dtAcesso;
		this.coStatus = coStatus;
		this.coTipoAcesso = coTipoAcesso;
	}
	public Date getDtAcesso() {
		return dtAcesso;
	}
	public void setDtAcesso(Date dtAcesso) {
		this.dtAcesso = dtAcesso;
	}
	public String getCoStatus() {
		return coStatus;
	}
	public void setCoStatus(String coStatus) {
		this.coStatus = coStatus;
	}
	public String getCoTipoAcesso() {
		return coTipoAcesso;
	}
	public void setCoTipoAcesso(String coTipoAcesso) {
		this.coTipoAcesso = coTipoAcesso;
	}

	public Integer getIdComercio() {
		return idComercio;
	}

	public void setIdComercio(Integer idComercio) {
		this.idComercio = idComercio;
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

	public String getNoCidade() {
		return noCidade;
	}

	public void setNoCidade(String noCidade) {
		this.noCidade = noCidade;
	}

	public String getDeLogradouro() {
		return deLogradouro;
	}

	public void setDeLogradouro(String deLogradouro) {
		this.deLogradouro = deLogradouro;
	}

	public String getNuLogradouro() {
		return nuLogradouro;
	}

	public void setNuLogradouro(String nuLogradouro) {
		this.nuLogradouro = nuLogradouro;
	}

	public String getDeCoplementoLogradouro() {
		return deCoplementoLogradouro;
	}

	public void setDeCoplementoLogradouro(String deCoplementoLogradouro) {
		this.deCoplementoLogradouro = deCoplementoLogradouro;
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
	
	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}
}
