package com.thoughtworks.Guess;

import com.thoughtworks.Exception.InputException;

import java.util.Scanner;

public class CheckEachGuess {
    public Guess typeGuess(int n) throws InputException {

        System.out.printf("请输入尝试的数字，剩余%d次数\n", 6 - n);
        Scanner sc = new Scanner(System.in);
        String typeGuess = sc.next();
        try {
            new Guess(typeGuess);
            return new Guess(typeGuess);
        } catch (InputException e) {
            System.out.println(e.getMessage());
            return typeGuess(n);
        }
    }


}
