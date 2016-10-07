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
@Table(name = "tb005_comercio_cliente", schema = "public")
public class ComercioClienteEntity extends BaseEntity<ComercioClientePkEntity>  implements Serializable {

	private static final long serialVersionUID = 5489495288008760483L;

	private ComercioClientePkEntity id;
	private Date dtVinculo;
	private UsuarioEntity usuario;
	private ComercioEntity comercio;

	public ComercioClienteEntity() {
		super();
	}

	public ComercioClienteEntity(ComercioClientePkEntity id, Date dtVinculo, UsuarioEntity usuario,
			ComercioEntity comercio) {
		super();
		this.id = id;
		this.dtVinculo = dtVinculo;
		this.usuario = usuario;
		this.comercio = comercio;
	}

	@EmbeddedId
	public ComercioClientePkEntity getId() {
		return id;
	}

	public void setId(ComercioClientePkEntity id) {
		this.id = id;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "dt_vinculo", nullable = false, insertable = false, updatable = false)
	public Date getDtVinculo() {
		return dtVinculo;
	}

	public void setDtVinculo(Date dtVinculo) {
		this.dtVinculo = dtVinculo;
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
