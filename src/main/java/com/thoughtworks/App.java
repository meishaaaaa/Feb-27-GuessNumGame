package com.thoughtworks;


import com.sun.tools.javac.comp.Check;

public class App {

    public static void main(String[] args) {

        //输入输出和流程控制在 App 类中做

        SetGame game = new SetGame();
        game.setCorrectAnswer();
        String correctAnswer = game.getCorrectAnswer();
        System.out.println(correctAnswer);

        SetGame.runCheck(correctAnswer);
    }

}




