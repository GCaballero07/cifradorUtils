package com.jaiba.cifrador.entity;

public class RequestDescifrado {

  private String cadena;

  private boolean formatoJson;

  public String getCadena() {
    return cadena;
  }

  public void setCadena(String cadena) {
    this.cadena = cadena;
  }

  public boolean isFormatoJson() {
    return formatoJson;
  }

  public void setFormatoJson(boolean formatoJson) {
    this.formatoJson = formatoJson;
  }

  @Override
  public String toString() {
    return "RequestDescifrado{" + "cadena='" + cadena + '\'' + ", formatoJson=" + formatoJson + '}';
  }
}
