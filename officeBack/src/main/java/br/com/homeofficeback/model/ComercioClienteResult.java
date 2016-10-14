package br.com.homeofficeback.model;

import java.io.Serializable;

public class ComercioClienteResult implements Serializable{

	private static final long serialVersionUID = -8053862197910747145L;

	private Integer id;
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
	
	private Integer totalAcessos = 0, totalAcessosCartela = 0, totalBonus = 0;

	public ComercioClienteResult() {
		super();
	}

	public ComercioClienteResult(Integer id, String deRazaoSocial, String noFantazia, String noCep,
			String deLocalizacao, String noBairro, String noCidade, String deLogradouro, String nuLogradouro,
			String deCoplementoLogradouro, Integer nuDddTelefoneFixo, Integer nuTelefoneFixo, Integer nuDddCelular,
			Integer nuCelular, String deEmail, Integer totalAcessos, Integer totalAcessosCartela, Integer totalBonus) {
		super();
		this.id = id;
		this.deRazaoSocial = deRazaoSocial;
		this.noFantazia = noFantazia;
		this.noCep = noCep;
		this.deLocalizacao = deLocalizacao;
		this.noBairro = noBairro;
		this.noCidade = noCidade;
		this.deLogradouro = deLogradouro;
		this.nuLogradouro = nuLogradouro;
		this.deCoplementoLogradouro = deCoplementoLogradouro;
		this.nuDddTelefoneFixo = nuDddTelefoneFixo;
		this.nuTelefoneFixo = nuTelefoneFixo;
		this.nuDddCelular = nuDddCelular;
		this.nuCelular = nuCelular;
		this.deEmail = deEmail;
		this.totalAcessos = totalAcessos;
		this.totalAcessosCartela = totalAcessosCartela;
		this.totalBonus = totalBonus;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Integer getTotalAcessos() {
		return totalAcessos;
	}

	public void setTotalAcessos(Integer totalAcessos) {
		this.totalAcessos = totalAcessos;
	}

	public Integer getTotalAcessosCartela() {
		return totalAcessosCartela;
	}

	public void setTotalAcessosCartela(Integer totalAcessosCartela) {
		this.totalAcessosCartela = totalAcessosCartela;
	}

	public Integer getTotalBonus() {
		return totalBonus;
	}

	public void setTotalBonus(Integer totalBonus) {
		this.totalBonus = totalBonus;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
