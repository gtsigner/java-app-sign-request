package com.demo;

public final class Base64 {

    public static String encode(byte[] bArr) {
        java.util.Base64.Encoder encoder = java.util.Base64.getEncoder();
        return encoder.encodeToString(bArr);
    }

}
