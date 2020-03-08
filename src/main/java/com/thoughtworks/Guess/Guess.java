package com.thoughtworks.Guess;

import com.thoughtworks.Exception.InputException;
import com.thoughtworks.Validator;


public class Guess {
    private String guess;

    public Guess() {
    }

    public Guess(String guess) throws InputException {
        this.guess = guess;
        if (!Validator.validateFormat(guess)) {
            throw new InputException("Wrong input!");
        }
    }

    public String getGuess() {
        return guess;
    }
}
