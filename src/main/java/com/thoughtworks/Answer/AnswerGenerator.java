package com.thoughtworks.Answer;

import com.thoughtworks.Validator;

import java.io.*;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class AnswerGenerator {
    private static final int ANSWER_LENGTH = 4;

    public Answer getCorrectAnswer(String fileName) {
        Answer answer = getAnswerFromFile(fileName);
        if (answer != null) return answer;
        //用set集合
        return getRandomAnswer();
    }


    private Answer getRandomAnswer() {
        Random r = new Random();
        Set<Integer> set = new HashSet<>();
        do {
            int num = r.nextInt(10);
            set.add(num);
        } while (set.size() < ANSWER_LENGTH);

        StringBuilder getRandomNum = new StringBuilder();
        for (Integer i : set) {
            getRandomNum.append(i);
        }
        return new Answer(getRandomNum.toString());
    }

    private Answer getAnswerFromFile(String fileName) {
        try {
            StringBuilder sb = new StringBuilder();
            InputStream stream = Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName);
            if (stream != null) {
                BufferedReader br = new BufferedReader(new InputStreamReader(stream));
                String temp;
                while ((temp = br.readLine()) != null) {
                    sb.append(temp);
                }
                if (Validator.validateFormat(sb.toString())) {
                    return new Answer(sb.toString());
                }
                br.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //用boolean数组来实现
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


//    public static String getInt(int[] num) {
//        StringBuilder sb = new StringBuilder();
//        for (Integer i : num) {
//            sb.append(i);
//        }
//        return sb.toString();
//    }


}
