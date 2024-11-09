package com.example.demo.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {
    public static Matcher idValidator(String id){
        return Pattern.compile("\\w+-(1000|[1-9][0-9]{0,2}|[1-9][0-9]{3}|10000)").matcher(id);
    }
}
