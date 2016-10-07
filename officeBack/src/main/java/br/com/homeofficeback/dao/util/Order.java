package br.com.homeofficeback.dao.util;

public enum Order {

	ASC, DESC;

	
	public boolean isAscOrder() {
		return ASC.equals(this);
	}
}
