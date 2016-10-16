package utils;

import java.io.UnsupportedEncodingException;

public class StringSerializer {

    public static String serialize(byte[] textInBytes) {
        try {
            return new String(textInBytes, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            return "";
        }
    }
}
