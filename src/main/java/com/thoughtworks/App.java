package com.thoughtworks;


public class App {

    public static void main(String[] args) {

        //输入输出和流程控制在 App 类中做

        SetGame game = new SetGame();
        game.setCorrectAnswer();
        String correctAnswer = game.getCorrectAnswer();

        runCheck(correctAnswer);
    }

    public static void runCheck(String correctAnswer) {

        CheckUserGuess user = new CheckUserGuess();
        StringBuilder reviewLastGuess = new StringBuilder();

        for (int i = 0; i < SetGame.getTryNumber(); i++) {
            String guess = user.typeGuess(i);

            if (user.isAnswerCorrect(guess, correctAnswer)) {
                System.out.println("Congratulations, you win!");
                break;
            } else {
                String thisOutput = user.giveOutput(guess, correctAnswer);
                reviewLastGuess.append(guess).append(" ").append(thisOutput).append("\n");
                System.out.print(reviewLastGuess.toString());
            }
            if (i == SetGame.getTryNumber() - 1) {
                System.out.printf("Unfortunately, you have no chance, the answer is %s!", correctAnswer);
            }
        }
    }

}




