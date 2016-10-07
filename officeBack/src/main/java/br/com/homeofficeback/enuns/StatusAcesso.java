package br.com.homeofficeback.enuns;

public enum StatusAcesso {
	ABERTO("A"),
	CONCLUIDO("C"),
	PAGAMENTO_PENDENTE("P"),
	EXCLUIDO("E");
	
	public String value;

	private StatusAcesso(String value){
		this.value = value;
	}
}
