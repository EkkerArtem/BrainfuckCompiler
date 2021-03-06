package com.javaclasses.brainfuckcompiler.impl;

/**
 * An interface for compiling input, written on brainfuck language. See <a href="https://en.wikipedia.org/wiki/Brainfuck"></a>.
 * It will translate, performOperation and return result of brainfuck code inputted.
 */
public interface Compile {
    /**
     * Method for compiling read brainfuck code.
     * Return the result of compiling the brainfuck code.
     */
    void compile() throws CommandException;

    /**
     * Method for reading the input string. It return the input string so it can be used to compile it
     * as many times as wanted.
     *
     * @param input inputData is an inputted brainfuck code.
     */
    void read(String input);
}
