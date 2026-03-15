package com.jaiba.cifrador.business;

import com.jaiba.cifrador.entity.RequestCifrado;
import com.jaiba.cifrador.entity.RequestDescifrado;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Arrays;

public class CifradoBusiness {

  private String text;
  private boolean esJson;

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public boolean isEsJson() {
    return esJson;
  }

  public void setEsJson(boolean esJson) {
    this.esJson = esJson;
  }

  public CifradoBusiness(RequestCifrado requestCifrado) {
    super();
    this.text = requestCifrado.getCadenaCifrada();
    this.esJson = requestCifrado.isFormatoJson();
  }

  public CifradoBusiness(RequestDescifrado requestDescifrado) {
    super();
    this.text = requestDescifrado.getCadena();
    this.esJson = requestDescifrado.isFormatoJson();
  }

  public String validarDescifrado() {
    String cadenaClara = "";
    try {

    }
    catch (Exception e) {
      cadenaClara = "Incidencia al cifrar: " + Arrays.toString(e.getStackTrace()) ;
    }

    return cadenaClara;
  }

  private String cifrarAES_MW(String text) {
    String algoritmo = "AES/CBC/PKCS5Padding";
    String tipo = "AES";
    String vector = "ab50ca7ff110f57abb4c4cf8ec8ab453";
    String llave = "A0191ABBCE23662E8105D01FF69532FD";
    String cifrado = null;
    try {
      final AlgorithmParameterSpec ivSpec = new IvParameterSpec(Hex.decodeHex(vector.toCharArray()));
      final SecretKeySpec newKey = new SecretKeySpec(llave.getBytes(StandardCharsets.UTF_8), tipo);
      final Cipher cipher = Cipher.getInstance(algoritmo);
      cipher.init(Cipher.ENCRYPT_MODE, newKey, ivSpec);
      cifrado = Base64.encodeBase64String(cipher.doFinal(text.getBytes(StandardCharsets.UTF_8)));
    }
    catch (GeneralSecurityException | DecoderException e) {
      System.out.println("Fallo al cifrar!! - " + Arrays.toString(e.getStackTrace()));

    }
    return cifrado;
  }

  public String descifrarAES_MW(String text) {
    String algoritmo = "AES/CBC/PKCS5Padding";
    String tipo = "AES";
    String vector = "ab50ca7ff110f57abb4c4cf8ec8ab453";
    String llave = "A0191ABBCE23662E8105D01FF69532FD";
    String descifrado = text;

    try {
      AlgorithmParameterSpec ivSpec = new IvParameterSpec(Hex.decodeHex(vector.toCharArray()));
      SecretKeySpec newKey = new SecretKeySpec(llave.getBytes(StandardCharsets.UTF_8), tipo);
      Cipher cipher = Cipher.getInstance(algoritmo);
      cipher.init(Cipher.DECRYPT_MODE, newKey, ivSpec);
      descifrado = new String(cipher.doFinal(Base64.decodeBase64(text.getBytes(StandardCharsets.UTF_8))));
    }
    catch (GeneralSecurityException | DecoderException e) {
      System.out.println("[descifrarAES_MW] - Fallo al descifrar!! - " + Arrays.toString(e.getStackTrace()));
    }

    return descifrado;
  }

}
