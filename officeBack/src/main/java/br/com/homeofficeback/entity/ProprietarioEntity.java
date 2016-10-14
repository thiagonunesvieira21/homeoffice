package br.com.homeofficeback.entity;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb004_proprietario_comercio", schema = "public")
public class ProprietarioEntity extends BaseEntity<ProprietarioPkEntity> implements Serializable {

	private static final long serialVersionUID = 2063105762524962622L;

	private ProprietarioPkEntity id;
	private UsuarioEntity usuario;
	private ComercioEntity comercio;

	public ProprietarioEntity() {
		super();
	}

	@EmbeddedId
	public ProprietarioPkEntity getId() {
		return id;
	}

	public void setId(ProprietarioPkEntity id) {
		this.id = id;
	}

	@ManyToOne
	@JoinColumn(name = "nu_usuario", referencedColumnName = "nu_usuario", insertable=false, updatable=false)
	public UsuarioEntity getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioEntity usuario) {
		this.usuario = usuario;
	}

	@ManyToOne
	@JoinColumn(name = "nu_comercio", referencedColumnName = "nu_comercio", insertable=false, updatable=false)
	public ComercioEntity getComercio() {
		return comercio;
	}

	public void setComercio(ComercioEntity comercio) {
		this.comercio = comercio;
	}

}
