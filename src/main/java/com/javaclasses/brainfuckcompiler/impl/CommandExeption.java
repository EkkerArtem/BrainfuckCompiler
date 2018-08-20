package com.javaclasses.brainfuckcompiler.impl;

public class CommandExeption extends Exception {

    private final int errorPosition;

    public CommandExeption(String message, int errorPosition) {
        super(message);
        this.errorPosition = errorPosition;
    }

    public int getErrorPosition() {
        return errorPosition;
    }
}
