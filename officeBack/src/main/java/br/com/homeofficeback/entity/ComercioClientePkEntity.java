package br.com.homeofficeback.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Embeddable
public class ComercioClientePkEntity implements Serializable {

	private static final long serialVersionUID = -8433074958254431569L;

	private Integer nuUsuario;
	private Integer nuComercio;
	private Date dtVinculo;

	public ComercioClientePkEntity() {
		super();
	}

	public ComercioClientePkEntity(Integer nuUsuario, Integer nuComercio, Date dtVinculo) {
		super();
		this.nuUsuario = nuUsuario;
		this.nuComercio = nuComercio;
		this.dtVinculo = dtVinculo;
	}

	@Column(name = "nu_usuario", nullable = false)
	public Integer getNuUsuario() {
		return nuUsuario;
	}

	public void setNuUsuario(Integer nuUsuario) {
		this.nuUsuario = nuUsuario;
	}

	@Column(name = "nu_comercio", nullable = false)
	public Integer getNuComercio() {
		return nuComercio;
	}

	public void setNuComercio(Integer nuComercio) {
		this.nuComercio = nuComercio;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "dt_vinculo", nullable = false)
	public Date getDtVinculo() {
		return dtVinculo;
	}

	public void setDtVinculo(Date dtVinculo) {
		this.dtVinculo = dtVinculo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dtVinculo == null) ? 0 : dtVinculo.hashCode());
		result = prime * result + ((nuComercio == null) ? 0 : nuComercio.hashCode());
		result = prime * result + ((nuUsuario == null) ? 0 : nuUsuario.hashCode());
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
		ComercioClientePkEntity other = (ComercioClientePkEntity) obj;
		if (dtVinculo == null) {
			if (other.dtVinculo != null)
				return false;
		} else if (!dtVinculo.equals(other.dtVinculo))
			return false;
		if (nuComercio == null) {
			if (other.nuComercio != null)
				return false;
		} else if (!nuComercio.equals(other.nuComercio))
			return false;
		if (nuUsuario == null) {
			if (other.nuUsuario != null)
				return false;
		} else if (!nuUsuario.equals(other.nuUsuario))
			return false;
		return true;
	}

}
