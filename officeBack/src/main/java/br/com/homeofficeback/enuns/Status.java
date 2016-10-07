package br.com.homeofficeback.enuns;

public enum Status {
	
	ATIVO(1),
	INATIVO(0);
	
	public int value;

	private Status(int value){
		this.value = value;
	}
}
