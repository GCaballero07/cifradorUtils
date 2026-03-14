package com.jaiba.cifrador.utils;

import java.security.spec.AlgorithmParameterSpec;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class CifradoToken {

	private static final byte[] ivBytes = {
            2, -90, -127, -15, 25, -117, -121, 96, -26, 86, -127, -63, 101, -120, 93, 52 };
    private String aes = "AES";
    private String aesAlgorithm = "AES/CBC/PKCS5Padding";
    private String tokenDinamico = "451b08e95f5a9607";

    public String decifrarTokenCode(String text, String code) throws Exception {
        String tokenCode = code.substring(0, 16).concat(this.tokenDinamico);
        AlgorithmParameterSpec ivSpec = new IvParameterSpec(ivBytes);
        SecretKeySpec newKey = new SecretKeySpec(tokenCode.getBytes(), this.aes);
        Cipher cipher = null;
        try {
            cipher = Cipher.getInstance(this.aesAlgorithm);
            cipher.init(2, newKey, ivSpec);
            byte[] raw = cipher.doFinal(Base64.getUrlDecoder().decode(text));
            return new String(raw);
        } catch (Exception e) {
            throw new Exception("No se pudo descifrar correctamente");
        }
    }
    
}
