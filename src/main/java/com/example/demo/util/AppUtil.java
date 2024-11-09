package com.example.demo.util;

import java.util.Base64;

public class AppUtil {
    public static String profilePicBase64(byte[] profilePic){
        return Base64.getEncoder().encodeToString(profilePic);
    }
}
