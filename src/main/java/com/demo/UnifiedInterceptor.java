package com.demo;

import okhttp3.*;
import okio.Buffer;
import sun.security.provider.MD5;

import java.io.IOException;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.LinkedHashMap;

public class UnifiedInterceptor implements Interceptor {


    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        RequestBody body = request.body();
        Headers headers = request.headers();
        String str = "";
        if (body != null) {
            Buffer buffer = new Buffer();
            body.writeTo(buffer);
            str = buffer.clone().readString(Charset.forName("UTF-8"));
        }
        LinkedHashMap map = this.headers(str);

        return null;
    }

    public static String sign(String str) {
        byte[] bytes = str.getBytes();
        str = Base64.encode(bytes) + "ryE5sW5hbmRyy2lkNDEkkYr";
        //08be1712cde9e6a50c49267a501aabb4
        //dfea87c82cfa39debeb0a98c5377c256
        //签名
        System.out.println(str);
        MessageDigest digest = null;
        try {
            digest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        if (digest != null) {
            digest.update(str.getBytes(Charset.forName("UTF-8")));
        }
        byte[] res = new byte[0];
        if (digest != null) {
            res = digest.digest();
        }
        StringBuilder result = new StringBuilder();
        for (byte re : res) {
            result.append(Integer.toHexString((0x000000FF & re) | 0xFFFFFF00).substring(6));
        }
        return result.toString();
    }

    private LinkedHashMap<String, String> headers(String str) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        String a = "c64a11a9c335422790085bf5b3efba0f";
        linkedHashMap.put("X-Udid", a);
        String valueOf = String.valueOf(System.currentTimeMillis());
        linkedHashMap.put("X-Client-Time", valueOf);
        linkedHashMap.put("X-Sign", str);
        String a2 = "";
        linkedHashMap.put("X-AccessToken", a2);
        String a3 = "";
        linkedHashMap.put("X-NetWork", a3);
        linkedHashMap.put("X-User-Agent", "");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{\"");
        stringBuilder.append("X-Udid");
        stringBuilder.append("\":\"");
        stringBuilder.append(a);
        stringBuilder.append("\",\"");
        stringBuilder.append("X-Client-Time");
        stringBuilder.append("\":\"");
        stringBuilder.append(valueOf);
        stringBuilder.append("\",\"");
        stringBuilder.append("X-Sign");
        stringBuilder.append("\":\"");
        stringBuilder.append(str);
        stringBuilder.append("\",\"");
        stringBuilder.append("X-AccessToken");
        stringBuilder.append("\":\"");
        stringBuilder.append(a2);
        stringBuilder.append("\",\"");
        stringBuilder.append("X-NetWork");
        stringBuilder.append("\":\"");
        stringBuilder.append(a3);
        stringBuilder.append("\",\"");
        stringBuilder.append("X-User-Agent");
        stringBuilder.append("\":\"");
        stringBuilder.append("");
        stringBuilder.append("\"}");
        linkedHashMap.put("X-Authentication", "");
        return linkedHashMap;
    }
}
