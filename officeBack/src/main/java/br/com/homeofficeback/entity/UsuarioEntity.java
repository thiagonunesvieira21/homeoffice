package br.com.homeofficeback.entity;

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
@Table(name = "tb001_usuario", schema = "public", uniqueConstraints = {
		@UniqueConstraint(columnNames = "de_login", name = "uk001"),
		@UniqueConstraint(columnNames = "nu_usuario", name = "pk_tb001"), })
@SequenceGenerator(name = "seq_nu_usuario_generator", sequenceName = "public.seq_nu_usuario", initialValue = 1, allocationSize = 1)
public class UsuarioEntity extends BaseEntity<Integer> implements java.io.Serializable {
	private static final long serialVersionUID = 3285079284755904458L;

	private Integer id;
	private String noUsuario;
	private String deLogin;
	private String deEmail;
	private String nuCpf;
	private Integer nuDddTelefoneFixo;
	private Integer nuTelefoneFixo;
	private Integer nuDddCelular;
	private Integer nuCelular;
	private String coSexo;
	private Date dhInclusao;
	private Integer coStatus;
	private Date dhStatus;
	private Date dhUltimoAcesso;
	private String deSenha;
	private Set<ProprietarioEntity> proprietarios;
	
	public UsuarioEntity() {
		super();
	}

	public UsuarioEntity(Integer id, String noUsuario, String deLogin, String deEmail, String nuCpf,
			Integer nuDddTelefoneFixo, Integer nuTelefoneFixo, Integer nuDddCelular, Integer nuCelular, String coSexo,
			Date dhInclusao, Integer coStatus, Date dhStatus, Date dhUltimoAcesso, String deSenha, Set<ProprietarioEntity> proprietarios) {
		super();
		this.id = id;
		this.noUsuario = noUsuario;
		this.deLogin = deLogin;
		this.deEmail = deEmail;
		this.nuCpf = nuCpf;
		this.nuDddTelefoneFixo = nuDddTelefoneFixo;
		this.nuTelefoneFixo = nuTelefoneFixo;
		this.nuDddCelular = nuDddCelular;
		this.nuCelular = nuCelular;
		this.coSexo = coSexo;
		this.dhInclusao = dhInclusao;
		this.coStatus = coStatus;
		this.dhStatus = dhStatus;
		this.dhUltimoAcesso = dhUltimoAcesso;
		this.deSenha = deSenha;
		this.proprietarios = proprietarios;
	}

	@Id
	@Column(name = "nu_usuario", nullable = false, unique = true)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_nu_usuario_generator")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "no_usuario", length = 60)
	public String getNoUsuario() {
		return noUsuario;
	}

	public void setNoUsuario(String noUsuario) {
		this.noUsuario = noUsuario;
	}

	@Column(name = "de_login", nullable = false, length = 80)
	public String getDeLogin() {
		return deLogin;
	}

	public void setDeLogin(String deLogin) {
		this.deLogin = deLogin;
	}

	@Column(name = "de_email", nullable = false, length = 80)
	public String getDeEmail() {
		return deEmail;
	}

	public void setDeEmail(String deEmail) {
		this.deEmail = deEmail;
	}

	@Column(name = "nu_cpf", length = 11)
	public String getNuCpf() {
		return nuCpf;
	}

	public void setNuCpf(String nuCpf) {
		this.nuCpf = nuCpf;
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

	@Column(name = "nu_ddd_celular", precision = 3, scale = 0)
	public Integer getNuDddCelular() {
		return nuDddCelular;
	}

	public void setNuDddCelular(Integer nuDddCelular) {
		this.nuDddCelular = nuDddCelular;
	}

	@Column(name = "nu_celular", precision = 9, scale = 0)
	public Integer getNuCelular() {
		return nuCelular;
	}

	public void setNuCelular(Integer nuCelular) {
		this.nuCelular = nuCelular;
	}

	@Column(name = "co_sexo", length = 1)
	public String getCoSexo() {
		return coSexo;
	}

	public void setCoSexo(String coSexo) {
		this.coSexo = coSexo;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dh_inclusao")
	public Date getDhInclusao() {
		return dhInclusao;
	}

	public void setDhInclusao(Date dhInclusao) {
		this.dhInclusao = dhInclusao;
	}

	@Column(name = "co_status", length = 1)
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

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dh_utilmo_acesso")
	public Date getDhUltimoAcesso() {
		return dhUltimoAcesso;
	}

	public void setDhUltimoAcesso(Date dhUltimoAcesso) {
		this.dhUltimoAcesso = dhUltimoAcesso;
	}

	@Column(name = "de_senha", nullable = false, length = 255)
	public String getDeSenha() {
		return deSenha;
	}

	public void setDeSenha(String deSenha) {
		this.deSenha = deSenha;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "comercio")
	public Set<ProprietarioEntity> getProprietarios() {
		return proprietarios;
	}

	public void setProprietarios(Set<ProprietarioEntity> proprietarios) {
		this.proprietarios = proprietarios;
	}
	
}
