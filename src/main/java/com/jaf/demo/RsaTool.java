package com.jaf.demo;

import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import java.security.MessageDigest;
import java.security.interfaces.RSAPublicKey;

public class RsaTool {
    /**
     * Rsa 加密
     *
     * @param str
     * @param str2
     * @param rSAPublicKey
     * @return
     * @throws Exception
     */
    public static String sign(String str, String str2, RSAPublicKey rSAPublicKey) throws Exception {
        String substring = md5(str).substring(8, 24);//只要後面一節
        return encode(substring + "@" + str2, rSAPublicKey);
    }

    //encode
    public static String encode(String str, RSAPublicKey rSAPublicKey) throws Exception {
        try {
            Cipher instance = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            instance.init(Cipher.ENCRYPT_MODE, rSAPublicKey);
            String base64 = new BASE64Encoder().encode(instance.doFinal(str.getBytes()));//算法加
            return SignCrypt.toHex(base64);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static String md5(String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(str.getBytes());
            byte[] digest = instance.digest();
            StringBuilder stringBuffer = new StringBuilder();
            for (int b : digest) {
                int i = b;
                if (i < 0)
                    i += 256;
                if (i < 16)
                    stringBuffer.append("0");
                stringBuffer.append(Integer.toHexString(i));
            }
            return stringBuffer.toString();
        } catch (Exception e) {
            return "";
        }
    }
}
