package br.com.homeofficeback.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb002_comercio", schema = "public", uniqueConstraints = {
		@UniqueConstraint(columnNames = "nu_comercio", name = "pk_tb002"), })
@SequenceGenerator(name = "seq_nu_comercio_generator", sequenceName = "public.seq_nu_comercio", initialValue = 1, allocationSize = 1)
public class ComercioEntity extends BaseEntity<Integer>  implements Serializable {

	private static final long serialVersionUID = 4847324358799884182L;

	private Integer id;
	private String deRazaoSocial;
	private String noFantazia;
	private String coTipoDocumento;
	private String deDocumento;
	private Date dhInclusao;
	private Integer coStatus;
	private Date dhStatus;
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
	private Set<ProprietarioEntity> proprietarios;

	public ComercioEntity() {
		super();
	}

	public ComercioEntity(Integer id, String deRazaoSocial, String noFantazia, String coTipoDocumento,
			String deDocumento, Date dhInclusao, Integer coStatus, Date dhStatus, String noCep, String deLocalizacao,
			String noBairro, String noCidade, String deLogradouro, String nuLogradouro, String deCoplementoLogradouro,
			Integer nuDddTelefoneFixo, Integer nuTelefoneFixo, Integer nuDddCelular, Integer nuCelular,
			String deEmail, Set<ProprietarioEntity> proprietarios) {
		super();
		this.id = id;
		this.deRazaoSocial = deRazaoSocial;
		this.noFantazia = noFantazia;
		this.coTipoDocumento = coTipoDocumento;
		this.deDocumento = deDocumento;
		this.dhInclusao = dhInclusao;
		this.coStatus = coStatus;
		this.dhStatus = dhStatus;
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
		this.proprietarios = proprietarios;
	}

	@Id
	@Column(name = "nu_comercio", nullable = false, unique = true)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_nu_comercio_generator")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "de_razao_social", nullable = false, length = 60)
	public String getDeRazaoSocial() {
		return deRazaoSocial;
	}

	public void setDeRazaoSocial(String deRazaoSocial) {
		this.deRazaoSocial = deRazaoSocial;
	}

	@Column(name = "no_fantasia", nullable = false, length = 60)
	public String getNoFantazia() {
		return noFantazia;
	}

	public void setNoFantazia(String noFantazia) {
		this.noFantazia = noFantazia;
	}

	@Column(name = "co_tipo_documento", nullable = false, length = 1)
	public String getCoTipoDocumento() {
		return coTipoDocumento;
	}

	public void setCoTipoDocumento(String coTipoDocumento) {
		this.coTipoDocumento = coTipoDocumento;
	}

	@Column(name = "de_documento", nullable = false, length = 60)
	public String getDeDocumento() {
		return deDocumento;
	}

	public void setDeDocumento(String deDocumento) {
		this.deDocumento = deDocumento;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dh_inclusao")
	public Date getDhInclusao() {
		return dhInclusao;
	}

	public void setDhInclusao(Date dhInclusao) {
		this.dhInclusao = dhInclusao;
	}

	@Column(name = "co_status", nullable = false, length = 1)
	public Integer getCoStatus() {
		return coStatus;
	}

	public void setCoStatus(Integer coStatus) {
		this.coStatus = coStatus;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dh_status")
	public Date getDhStatus() {
		return dhStatus;
	}

	public void setDhStatus(Date dhStatus) {
		this.dhStatus = dhStatus;
	}

	@Column(name = "no_cep", nullable = false, length = 8)
	public String getNoCep() {
		return noCep;
	}

	public void setNoCep(String noCep) {
		this.noCep = noCep;
	}

	@Column(name = "de_localizacao", length = 255)
	public String getDeLocalizacao() {
		return deLocalizacao;
	}

	public void setDeLocalizacao(String deLocalizacao) {
		this.deLocalizacao = deLocalizacao;
	}

	@Column(name = "no_bairro", length = 60)
	public String getNoBairro() {
		return noBairro;
	}

	public void setNoBairro(String noBairro) {
		this.noBairro = noBairro;
	}

	@Column(name = "no_cidade", nullable = false, length = 60)
	public String getNoCidade() {
		return noCidade;
	}

	public void setNoCidade(String noCidade) {
		this.noCidade = noCidade;
	}

	@Column(name = "de_logradouro", length = 60)
	public String getDeLogradouro() {
		return deLogradouro;
	}

	public void setDeLogradouro(String deLogradouro) {
		this.deLogradouro = deLogradouro;
	}

	@Column(name = "nu_logradouro", length = 8)
	public String getNuLogradouro() {
		return nuLogradouro;
	}

	public void setNuLogradouro(String nuLogradouro) {
		this.nuLogradouro = nuLogradouro;
	}

	@Column(name = "de_complemento_logradouro", length = 60)
	public String getDeCoplementoLogradouro() {
		return deCoplementoLogradouro;
	}

	public void setDeCoplementoLogradouro(String deCoplementoLogradouro) {
		this.deCoplementoLogradouro = deCoplementoLogradouro;
	}

	@Column(name = "nu_ddd_telefone_fixo", precision = 3, scale = 0)
	public Integer getNuDddTelefoneFixo() {
		return nuDddTelefoneFixo;
	}

	public void setNuDddTelefoneFixo(Integer nuDddTelefoneFixo) {
		this.nuDddTelefoneFixo = nuDddTelefoneFixo;
	}

	@Column(name = "nu_telefone_fixo", precision = 9, scale = 0)
	public Integer getNuTelefoneFixo() {
		return nuTelefoneFixo;
	}

	public void setNuTelefoneFixo(Integer nuTelefoneFixo) {
		this.nuTelefoneFixo = nuTelefoneFixo;
	}

	@Column(name = "nu_ddd_celular", nullable = false, precision = 3, scale = 0)
	public Integer getNuDddCelular() {
		return nuDddCelular;
	}

	public void setNuDddCelular(Integer nuDddCelular) {
		this.nuDddCelular = nuDddCelular;
	}

	@Column(name = "nu_celular", nullable = false, precision = 9, scale = 0)
	public Integer getNuCelular() {
		return nuCelular;
	}

	public void setNuCelular(Integer nuCelular) {
		this.nuCelular = nuCelular;
	}

	@Column(name = "de_email", nullable = false, length = 80)
	public String getDeEmail() {
		return deEmail;
	}

	public void setDeEmail(String deEmail) {
		this.deEmail = deEmail;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "comercio")
	@JsonIgnore
	public Set<ProprietarioEntity> getProprietarios() {
		return proprietarios;
	}

	public void setProprietarios(Set<ProprietarioEntity> proprietarios) {
		this.proprietarios = proprietarios;
	}

}
