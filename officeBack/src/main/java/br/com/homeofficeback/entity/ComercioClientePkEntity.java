package br.com.homeofficeback.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Embeddable
public class ComercioClientePkEntity implements Serializable {

	private static final long serialVersionUID = -8433074958254431569L;

	private UsuarioEntity usuario;
	private ComercioEntity comercio;
	private Date dtVinculo;

	public ComercioClientePkEntity() {
		super();
	}

	public ComercioClientePkEntity(UsuarioEntity usuario, ComercioEntity comercio, Date dtVinculo) {
		super();
		this.usuario = usuario;
		this.comercio = comercio;
		this.dtVinculo = dtVinculo;
	}

	@ManyToOne
	@JoinColumn(name = "nu_usuario", columnDefinition="nu_usuario", referencedColumnName="nu_usuario")
	public UsuarioEntity getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioEntity usuario) {
		this.usuario = usuario;
	}

	@ManyToOne
	@JoinColumn(name = "nu_comercio", columnDefinition="nu_comercio", referencedColumnName="nu_comercio")
	public ComercioEntity getComercio() {
		return comercio;
	}

	public void setComercio(ComercioEntity comercio) {
		this.comercio = comercio;
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
		result = prime * result + ((comercio == null) ? 0 : comercio.hashCode());
		result = prime * result + ((dtVinculo == null) ? 0 : dtVinculo.hashCode());
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
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
		if (comercio == null) {
			if (other.comercio != null)
				return false;
		} else if (!comercio.equals(other.comercio))
			return false;
		if (dtVinculo == null) {
			if (other.dtVinculo != null)
				return false;
		} else if (!dtVinculo.equals(other.dtVinculo))
			return false;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		return true;
	}

}
