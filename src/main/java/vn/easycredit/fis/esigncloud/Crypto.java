/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.easycredit.fis.esigncloud;

import java.security.PrivateKey;
import javax.crypto.Cipher;
import javax.xml.bind.DatatypeConverter;

/**
 *
 * @author VUDP
 */
public class Crypto {

    /**
     * decryptRSA
     *
     * Decrypt a message using RSA Private Key
     *
     * @param message the encrypted message in base64 format
     * @param privateKey the Private Key is used to decrypt
     */
    public static String decryptRSA(String message, PrivateKey privateKey) {
        String result = null;
        try {
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(Cipher.DECRYPT_MODE, privateKey);
            result = new String(cipher.doFinal(DatatypeConverter.parseBase64Binary(message)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
