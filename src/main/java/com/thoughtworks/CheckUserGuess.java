package com.thoughtworks;


import java.util.Scanner;

public class CheckUserGuess {


    public String typeGuess(int n) throws InputException {

        System.out.printf("请输入尝试的数字，剩余%d次数\n", 6 - n);
        Scanner sc = new Scanner(System.in);
        String typeGuess = sc.next();
        try {
            checkFormat(typeGuess);
            return typeGuess;
        } catch (InputException e) {
            System.out.println(e.getMessage());
            return typeGuess(n);
        }
    }

    public CheckUserGuess() {
    }


    private void checkFormat(String guessValue) throws InputException {
        if (!AnswerFromFIle.isCorrectFormat(guessValue)) {
            throw new InputException("Wrong input!");
        }
    }


//        First version:
//        try {
//            System.out.printf("请输入尝试的数字，剩余%d次数\n", 6 - n);
//            Scanner sc = new Scanner(System.in);
//            String guess = sc.next();
//            if (AnswerFromFIle.isCorrectFormat(guess)) {
//                return guess;
//            }
//            if (!AnswerFromFIle.isCorrectFormat(guess)) {
//                throw new InputException("Wrong input");
//            }
//        } catch (InputException e) {
//            System.out.println("Wrong input");
//        }
//        return typeGuess(n);
//    }

    public boolean isAnswerCorrect(String guess, String correctAnswer) {
        return guess.equals(correctAnswer);
    }

    public String giveOutput(String guess, String correctAnswer) {

        int numOfA = checkNumOfA(guess, correctAnswer);
        int numOfB = checkNumOfB(guess, correctAnswer);

        return numOfA + "A" + numOfB + "B";
    }

    private int checkNumOfA(String guess, String correctAnswer) {
        char[] charA = guess.toCharArray();
        char[] charB = correctAnswer.toCharArray();

        int numOfA = 0;
        for (int i = 0; i < charA.length; i++) {
            if (charA[i] == charB[i]) {
                numOfA++;
            }
        }
        return numOfA;
    }

    private int checkNumOfB(String guess, String correctAnswer) {
        char[] charA = guess.toCharArray();
        char[] charB = correctAnswer.toCharArray();

        int numOfA = 0;
        for (int i = 0; i < charA.length; i++) {
            if (charA[i] == charB[i]) {
                numOfA++;
            }
        }

        int numOfB = 0;
        for (Character charsA : charA) {
            for (Character charsB : charB) {
                if (charsA.equals(charsB)) {
                    numOfB++;
                }
            }
        }
        numOfB -= numOfA;
        return numOfB;
    }
}

