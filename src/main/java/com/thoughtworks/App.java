package com.thoughtworks;


import com.thoughtworks.Game.Result;
import com.thoughtworks.Game.SetGame;

public class App {

    public static void main(String[] args) {

        //输入输出和流程控制在 App 类中做

        String fileName = "answer.txt";
        SetGame game = new SetGame(fileName);

        Result.runCheck(game.getCorrectAnswer());


    }

}




