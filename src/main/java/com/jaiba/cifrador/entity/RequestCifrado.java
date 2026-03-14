package com.jaiba.cifrador.entity;

public class RequestCifrado {

	private String cadenaCifrada;
	
	private boolean formatoJson;

	public String getCadenaCifrada() {
		return cadenaCifrada;
	}

	public void setCadenaCifrada(String cadenaCifrada) {
		this.cadenaCifrada = cadenaCifrada;
	}

	public boolean isFormatoJson() {
		return formatoJson;
	}

	public void setFormatoJson(boolean formatoJson) {
		this.formatoJson = formatoJson;
	}

	@Override
	public String toString() {
		return "RequestCifrado [cadenaCifrada=" + cadenaCifrada + ", formatoJson=" + formatoJson + "]";
	}
	
}
