package br.com.homeofficeback.model;

import javax.validation.constraints.Size;
import javax.ws.rs.FormParam;

public class PesquisarComercio {

	@Size(max = 60)
	@FormParam("deRazaoSocial")
	private String deRazaoSocial;
	
	@Size(max = 60)
	@FormParam("noFantazia")
	private String noFantazia;
	
	@Size(max = 60)
	@FormParam("noCidade")
	private String noCidade;

	public PesquisarComercio() {
		super();
	}

	public PesquisarComercio(String deRazaoSocial, String noFantazia, String noCidade) {
		super();
		this.deRazaoSocial = deRazaoSocial;
		this.noFantazia = noFantazia;
		this.noCidade = noCidade;
	}

	public String getDeRazaoSocial() {
		return deRazaoSocial;
	}

	public void setDeRazaoSocial(String deRazaoSocial) {
		this.deRazaoSocial = deRazaoSocial;
	}

	public String getNoFantazia() {
		return noFantazia;
	}

	public void setNoFantazia(String noFantazia) {
		this.noFantazia = noFantazia;
	}

	public String getNoCidade() {
		return noCidade;
	}

	public void setNoCidade(String noCidade) {
		this.noCidade = noCidade;
	}	
}
