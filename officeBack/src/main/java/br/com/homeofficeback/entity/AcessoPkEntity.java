package br.com.homeofficeback.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Embeddable
public class AcessoPkEntity implements Serializable {

	private static final long serialVersionUID = 1913143738258132364L;

	private Integer nuUsuario;
	private Integer nuComercio;
	private Date dtAcesso;

	public AcessoPkEntity() {
		super();
	}

	public AcessoPkEntity(Integer nuUsuario, Integer nuComercio, Date dtAcesso) {
		super();
		this.nuUsuario = nuUsuario;
		this.nuComercio = nuComercio;
		this.dtAcesso = dtAcesso;
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
	@Column(name = "dt_acesso", nullable = false)
	public Date getDtAcesso() {
		return dtAcesso;
	}

	public void setDtAcesso(Date dtAcesso) {
		this.dtAcesso = dtAcesso;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dtAcesso == null) ? 0 : dtAcesso.hashCode());
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
		AcessoPkEntity other = (AcessoPkEntity) obj;
		if (dtAcesso == null) {
			if (other.dtAcesso != null)
				return false;
		} else if (!dtAcesso.equals(other.dtAcesso))
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
