package com.thoughtworks;

public class SetGame {
    private String correctAnswer;

    public void setCorrectAnswer() {
        AnswerFromFIle answer = new AnswerFromFIle();
        this.correctAnswer = answer.getAnswer();
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public static int getTryNumber() {
        return 6;
    }


}


