package br.com.homeofficeback.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tb005_comercio_cliente", schema = "public")
public class ComercioClienteEntity extends BaseEntity<ComercioClientePkEntity> implements Serializable {

	private static final long serialVersionUID = 5489495288008760483L;

	private ComercioClientePkEntity id;
	private Date dtVinculo;
	private Integer nuUsuario;
	private Integer nuComercio;

	public ComercioClienteEntity() {
		super();
	}

	public ComercioClienteEntity(ComercioClientePkEntity id, Date dtVinculo, Integer nuUsuario, Integer nuComercio) {
		super();
		this.id = id;
		this.dtVinculo = dtVinculo;
		this.nuUsuario = nuUsuario;
		this.nuComercio = nuComercio;
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

	@Column(name = "nu_usuario", nullable = false, insertable = false, updatable = false)
	public Integer getNuUsuario() {
		return nuUsuario;
	}

	public void setNuUsuario(Integer nuUsuario) {
		this.nuUsuario = nuUsuario;
	}

	@Column(name = "nu_comercio", nullable = false, insertable = false, updatable = false)
	public Integer getNuComercio() {
		return nuComercio;
	}

	public void setNuComercio(Integer nuComercio) {
		this.nuComercio = nuComercio;
	}

}
