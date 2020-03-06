package com.thoughtworks;

import java.io.*;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class AnswerFromFIle implements GenerateAnswer {

    @Override
    public String getAnswer() {
        String sb = getAnswerFromFile();
        if (sb != null) return sb;
        //用set集合
        return getRandomAnswer();
    }

//        //用boolean数组来实现
//        int [] num=new int[]{0,1,2,3,4,5,6,7,8,9};
//        boolean[] boo = new boolean[num.length];
//        int [] newAnswer=new int[getAnswerCount()];
//        for (int i = 0; i < getAnswerCount(); i++) {
//            int index;
//            do{
//                index = (int)(Math.random()*(num.length));
//            }while(boo[index]);
//            newAnswer[i]=num[index];
//            boo[index]=true;
//        }
//
//
//        return getInt(newAnswer);

    private String getRandomAnswer() {
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

    private String getAnswerFromFile() {
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
        return null;
    }

//    public static String getInt(int[] num) {
//        StringBuilder sb = new StringBuilder();
//        for (Integer i : num) {
//            sb.append(i);
//        }
//        return sb.toString();
//    }


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
