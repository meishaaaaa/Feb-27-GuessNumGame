package com.thoughtworks.Game;

import com.thoughtworks.Answer.Answer;
import com.thoughtworks.Answer.AnswerGenerator;

public class SetGame {
    private Answer correctAnswer;
    public final static int TRY_LIMIT = 6;

    public Answer getCorrectAnswer() {
        return correctAnswer;
    }

    public SetGame(String fileName) {
        AnswerGenerator answerGenerator = new AnswerGenerator();
        this.correctAnswer = answerGenerator.getCorrectAnswer(fileName);
    }

}
