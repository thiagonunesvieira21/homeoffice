package br.com.homeofficeback.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tb006_cartela", schema = "public")
public class CartelaEntity extends BaseEntity<CartelaPkEntity> implements Serializable {

	private static final long serialVersionUID = -9006469932407919320L;

	private CartelaPkEntity id;
	private Date dhUltimaCarga;
	private UsuarioEntity usuario;
	private ComercioEntity comercio;
	private Integer qtAcesso, qtLimiteAcessos, qtAcessoBonus, status;
	
	public CartelaEntity() {
		super();
	}

	public CartelaEntity(CartelaPkEntity id, Date dhUltimaCarga, UsuarioEntity usuario, ComercioEntity comercio,
			Integer qtAcesso, Integer qtLimiteAcessos, Integer qtAcessoBonus, Integer status) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.comercio = comercio;
		this.qtAcesso = qtAcesso;
		this.qtLimiteAcessos = qtLimiteAcessos;
		this.qtAcessoBonus = qtAcessoBonus;
		this.status = status;
		this.dhUltimaCarga = dhUltimaCarga;
	}

	@EmbeddedId
	public CartelaPkEntity getId() {
		return id;
	}

	public void setId(CartelaPkEntity id) {
		this.id = id;
	}
	
	@Temporal(TemporalType.DATE)
	@Column(name = "dh_ultima_carga", nullable = false, insertable = false, updatable = false)
	public Date getDhUltimaCarga() {
		return dhUltimaCarga;
	}

	public void setDhUltimaCarga(Date dhUltimaCarga) {
		this.dhUltimaCarga = dhUltimaCarga;
	}
	
	@ManyToOne
	@PrimaryKeyJoinColumn(name = "tb001_usuario", columnDefinition = "nu_usuario", referencedColumnName = "nu_usuario")
	public UsuarioEntity getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioEntity usuario) {
		this.usuario = usuario;
	}

	@ManyToOne
	@PrimaryKeyJoinColumn(name = "tb002_comercio", columnDefinition = "nu_comercio", referencedColumnName = "nu_comercio")
	public ComercioEntity getComercio() {
		return comercio;
	}
	
	public void setComercio(ComercioEntity comercio) {
		this.comercio = comercio;
	}

	@Column(name="qt_acesso", nullable=false)
	public Integer getQtAcesso() {
		return qtAcesso;
	}

	public void setQtAcesso(Integer qtAcesso) {
		this.qtAcesso = qtAcesso;
	}

	@Column(name="qt_limite_acessos", nullable=false)
	public Integer getQtLimiteAcessos() {
		return qtLimiteAcessos;
	}

	public void setQtLimiteAcessos(Integer qtLimiteAcessos) {
		this.qtLimiteAcessos = qtLimiteAcessos;
	}

	@Column(name="qt_acesso_bonus", nullable=false)
	public Integer getQtAcessoBonus() {
		return qtAcessoBonus;
	}

	public void setQtAcessoBonus(Integer qtAcessoBonus) {
		this.qtAcessoBonus = qtAcessoBonus;
	}

	@Column(name="co_status", nullable=false)
	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	
}
