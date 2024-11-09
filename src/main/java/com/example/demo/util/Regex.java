package com.example.demo.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {
    public static Matcher idValidator(String id){
        return Pattern.compile("\\w+-(1000|[1-9][0-9]{0,2}|[1-9][0-9]{3}|10000)").matcher(id);
    }

    public static Matcher emailValidator(String email){
        return Pattern.compile("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$").matcher(email);
    }
}
