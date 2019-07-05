package com.jaf.demo;


import com.itextpdf.text.pdf.security.SecurityConstants;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;
import sun.misc.CharacterEncoder;

import java.io.IOException;
import java.security.KeyFactory;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.X509EncodedKeySpec;

public class Rsa {
    private static RSAPublicKey rsaKey = null;
    private static final String key = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQC20UxmCtTo4wSdTssLJ5Gvn7zMzpHDWKJwWklV\nlOM9mJGseFa9iK1+nmOU79hVloLrHy5TagsLC8w7wypsPltxmEDC57Cl58nMLRtfBPOusegz02sQ\nN6GEoKKexnmcZeBGTQp8QigrcYCu+D78CxPfeyewnxflxSGtCdQ/4nCMhwIDAQAB";

    public static RSAPublicKey getRsaPublicKey() {
        if (rsaKey != null) {
            return rsaKey;
        }
        try {
            return b(key);
        } catch (Exception e) {
            return rsaKey;
        }
    }

    //base64
    public static byte[] strToBytes(String str) throws IOException {
        return new BASE64Decoder().decodeBuffer(str);
    }

    /**
     * 获取Rsa公钥
     *
     * @param str
     * @return
     * @throws Exception
     */
    public static RSAPublicKey b(String str) throws Exception {
        X509EncodedKeySpec data = new X509EncodedKeySpec(strToBytes(str));
        return (RSAPublicKey) KeyFactory.getInstance(SecurityConstants.RSA).generatePublic(data);
    }
}
