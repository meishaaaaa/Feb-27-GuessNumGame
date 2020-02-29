package com.thoughtworks;

import java.io.*;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class AnswerFromFIle implements GenerateAnswer {

    public String getAnswer() {
        File file = new File("answer.txt");
        if (file.exists()) {
            try {
                StringBuilder sb = new StringBuilder();
                BufferedReader br = new BufferedReader(new FileReader("answer.txt"));
                String temp;
                while ((temp = br.readLine()) != null) {
                    sb.append(temp);
                }
                if (isCorrectFormat(sb.toString())) {
                    return sb.toString();
                }
                br.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        Random r = new Random();
        Set<Integer> set = new HashSet<>();
        do {
            int num = r.nextInt(10);
            set.add(num);
        } while (set.size() < getAnswerCount());

        StringBuilder getRandomNum = new StringBuilder();
        for (Integer i : set) {
            getRandomNum.append(i);
        }
        return getRandomNum.toString();
    }


    public static boolean isCorrectFormat(String str) {
        Set<Integer> set = new HashSet<>();
        if (str.length() == AnswerFromFIle.getAnswerCount()) {
            for (int i = 0; i < str.length(); i++) {
                if (Character.isDigit(str.charAt(i))) {
                    set.add((int) (str.charAt(i)));
                }
            }
        }
        return set.size() == str.length();
    }

    public static int getAnswerCount() {
        return 4;
    }
}
