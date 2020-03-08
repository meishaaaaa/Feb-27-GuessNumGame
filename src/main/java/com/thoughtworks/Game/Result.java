package com.thoughtworks.Game;

import com.thoughtworks.Answer.Answer;
import com.thoughtworks.Guess.CheckEachGuess;

import java.util.Objects;

public class Result {
    public static void runCheck(Answer correctAnswer) {

        String answer = correctAnswer.getAnswer();
        CheckEachGuess g = new CheckEachGuess();
        StringBuilder reviewLastGuess = new StringBuilder();

        for (int i = 0; i < SetGame.TRY_LIMIT; i++) {
            String guess = g.typeGuess(i).getGuess();

            if (Objects.equals(guess, answer)) {
                System.out.println("Congratulations, you win!");
                break;
            } else {
                String thisOutput = giveOutput(guess, answer);
                reviewLastGuess.append(guess).append(" ").append(thisOutput).append("\n");
                System.out.print(reviewLastGuess.toString());
            }
            if (i == SetGame.TRY_LIMIT - 1) {
                System.out.printf("Unfortunately, you have no chance, the answer is %s!", answer);
            }
        }
    }


    private static String giveOutput(String guess, String correctAnswer) {

        int numOfA = checkNumOfA(guess, correctAnswer);
        int numOfB = checkNumOfB(guess, correctAnswer);

        return numOfA + "A" + numOfB + "B";
    }

    private static int checkNumOfA(String guess, String correctAnswer) {
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

    private static int checkNumOfB(String guess, String correctAnswer) {
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
