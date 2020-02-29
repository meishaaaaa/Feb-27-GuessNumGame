package com.thoughtworks;


import java.util.Scanner;

public class CheckUserGuess {


    public String typeGuess(int n) throws InputException {

        try {
            System.out.printf("请输入尝试的数字，剩余%d次数\n", 6 - n);
            Scanner sc = new Scanner(System.in);
            String guess = sc.next();
            if (AnswerFromFIle.isCorrectFormat(guess)) {
                return guess;
            }
            if (!AnswerFromFIle.isCorrectFormat(guess)) {
                throw new InputException("Wrong input");
            }
        } catch (InputException e) {
            System.out.println("Wrong input");
        }
        return typeGuess(n);
    }


    public boolean isAnswerCorrect(String guess, String correctAnswer) {
        boolean result = false;
        if (guess.equals(correctAnswer)) {
            result = true;
        }
        return result;
    }

    public String giveOutput(String guess, String correctAnswer) {

        int numOfA = checkNumOfA(guess, correctAnswer);
        int numOfB = checkNumOfB(guess, correctAnswer);

        return numOfA + "A" + numOfB + "B";
    }

    public int checkNumOfA(String guess, String correctAnswer) {
        char[] char1 = guess.toCharArray();
        char[] char2 = correctAnswer.toCharArray();

        int numOfA = 0;
        for (int i = 0; i < char1.length; i++) {
            if (char1[i] == char2[i]) {
                numOfA++;
            }
        }
        return numOfA;
    }

    public int checkNumOfB(String guess, String correctAnswer) {
        char[] char1 = guess.toCharArray();
        char[] char2 = correctAnswer.toCharArray();

        int numOfA = 0;
        for (int i = 0; i < char1.length; i++) {
            if (char1[i] == char2[i]) {
                numOfA++;
            }
        }

        int numOfB = 0;
        for (Character chars1 : char1) {
            for (Character chars2 : char2) {
                if (chars1.equals(chars2)) {
                    numOfB++;
                }
            }
        }
        numOfB -= numOfA;
        return numOfB;
    }
}

