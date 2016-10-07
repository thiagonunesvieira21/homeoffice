package br.com.homeofficeback.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class CartelaPkEntity implements Serializable {

	private static final long serialVersionUID = 9011876856452636697L;

	private Integer nuUsuario;
	private Integer nuComercio;

	public CartelaPkEntity() {
		super();
	}

	public CartelaPkEntity(Integer nuUsuario, Integer nuComercio) {
		super();
		this.nuUsuario = nuUsuario;
		this.nuComercio = nuComercio;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		CartelaPkEntity other = (CartelaPkEntity) obj;
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
