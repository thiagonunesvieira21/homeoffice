package br.com.homeofficeback.enuns;

public enum TipoAcesso {
	CARTELA("C"),
	AVULSO("A");
	
	public String value;

	private TipoAcesso(String value){
		this.value = value;
	}
}
