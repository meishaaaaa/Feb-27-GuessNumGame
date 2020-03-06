package com.thoughtworks;

public class SetGame {
    private String correctAnswer;



    public void setCorrectAnswer() {
        AnswerFromFIle answer = new AnswerFromFIle();
        this.correctAnswer = answer.getAnswer();
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

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public static int getTryNumber() {
        return 6;
    }


}


