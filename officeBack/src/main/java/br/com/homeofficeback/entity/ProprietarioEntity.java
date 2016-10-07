package br.com.homeofficeback.entity;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
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

}
