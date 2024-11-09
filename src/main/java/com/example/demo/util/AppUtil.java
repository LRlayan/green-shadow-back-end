package com.example.demo.util;

import java.util.Base64;
import java.util.UUID;

public class AppUtil {

    public static String generateCropCode(){
        return "CROP-" + (int)(Math.random() * 1000) + 1;
    }

    public static String generateEquipmentCode(){
        return "EQU-" + (int)(Math.random() * 1000) + 1;
    }

    public static String generateFieldCode(){
        return "FIELD-" + (int)(Math.random() * 1000) + 1;
    }

    public static String imageBase64(byte[] image){
        return Base64.getEncoder().encodeToString(image);
    }
}
