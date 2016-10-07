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
@Table(name = "tb003_acesso", schema = "public")
public class AcessoEntity extends BaseEntity<AcessoPkEntity> implements Serializable {

	private static final long serialVersionUID = -2908394878176636420L;

	private AcessoPkEntity id;
	private Date dtAcesso;
	private UsuarioEntity usuario;
	private ComercioEntity comercio;
	private String coStatus;
	private String coTipoAcesso;

	public AcessoEntity() {
		super();
	}

	public AcessoEntity(AcessoPkEntity id, Date dtAcesso, UsuarioEntity usuario, ComercioEntity comercio,
			String coStatus, String coTipoAcesso) {
		super();
		this.id = id;
		this.dtAcesso = dtAcesso;
		this.usuario = usuario;
		this.comercio = comercio;
		this.coStatus = coStatus;
		this.coTipoAcesso = coTipoAcesso;
	}

	@EmbeddedId
	public AcessoPkEntity getId() {
		return id;
	}

	public void setId(AcessoPkEntity id) {
		this.id = id;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "dt_acesso", nullable = false, insertable = false, updatable = false)
	public Date getDtAcesso() {
		return dtAcesso;
	}

	public void setDtAcesso(Date dtAcesso) {
		this.dtAcesso = dtAcesso;
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

	@Column(name = "co_status", nullable = false, length = 1)
	public String getCoStatus() {
		return coStatus;
	}

	public void setCoStatus(String coStatus) {
		this.coStatus = coStatus;
	}

	@Column(name = "co_tipo_acesso", nullable = false, length = 1)
	public String getCoTipoAcesso() {
		return coTipoAcesso;
	}

	public void setCoTipoAcesso(String coTipoAcesso) {
		this.coTipoAcesso = coTipoAcesso;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AcessoEntity other = (AcessoEntity) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
