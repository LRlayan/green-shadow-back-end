package com.example.demo.util;

import java.util.Base64;

public class AppUtil {
    public static String imageBase64(byte[] image){
        return Base64.getEncoder().encodeToString(image);
    }
}
