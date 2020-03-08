package com.thoughtworks;

import java.util.HashSet;
import java.util.Set;

public class Validator {
    private static final int ANSWER_LENGTH = 4;

    public static boolean validateFormat(String format) {
        Set<Integer> set = new HashSet<>();
        if (format.length() == ANSWER_LENGTH) {
            for (int i = 0; i < format.length(); i++) {
                if (Character.isDigit(format.charAt(i))) {
                    set.add((int) (format.charAt(i)));
                }
            }
        }
        return set.size() == format.length();
    }
}

