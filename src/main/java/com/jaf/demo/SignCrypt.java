package com.jaf.demo;

import org.apache.commons.lang3.CharUtils;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;

public class SignCrypt {
    public static String v = "";


    public static String encrypt(String str, String str2) {
        if (str == null || str.equals("")) {
            return "";
        }
        SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(), "DES");
        try {
            Cipher instance = Cipher.getInstance("DES/ECB/PKCS5Padding");
            instance.init(Cipher.ENCRYPT_MODE, secretKeySpec);
            byte[] bytes = instance.doFinal(str.getBytes(StandardCharsets.UTF_8));
            String base64 = new BASE64Encoder().encode(bytes);
            return SignCrypt.toHex(base64);
        } catch (Exception e) {
            return null;
        }
    }


    public static String decrypt(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            String d = convert(str);
            if (TextUtils.isEmpty(d)) {
                return "";
            }
            byte[] a = new BASE64Decoder().decodeBuffer(d);
            SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(), "DES");
            Cipher instance = Cipher.getInstance("DES/ECB/PKCS5Padding");
            instance.init(Cipher.DECRYPT_MODE, secretKeySpec);
            return new String(instance.doFinal(a), StandardCharsets.UTF_8);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 转hex
     *
     * @param str
     * @return
     */
    public static String toHex(String str) {
        StringBuilder stringBuffer = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (!(charAt == 10 || charAt == CharUtils.CR)) {
                stringBuffer.append(Integer.toHexString(charAt));
            }
        }
        return stringBuffer.toString();
    }

    public static String convert(String str) {
        try {
            byte[] bArr = new byte[(str.length() / 2)];
            for (int i = 0; i < bArr.length; i++) {
                bArr[i] = (byte) (Integer.parseInt(str.substring(i * 2, (i * 2) + 2), 16) & 255);
            }
            return new String(bArr, StandardCharsets.UTF_8);
        } catch (Exception e) {
            return "";
        }
    }
}
