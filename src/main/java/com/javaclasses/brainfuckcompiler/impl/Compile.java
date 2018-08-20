package com.javaclasses.brainfuckcompiler.impl;

/**
 * An interface for compiling input, written on brainfuck language. See <a href="https://en.wikipedia.org/wiki/Brainfuck"></a>.
 * It will translate, perform and return result of brainfuck code inputted.
 */
public interface Compile {
    /**
     * Return the result of compiling the brainfuck code.
     *
     * @param input inputData is an inputted brainfuck code.
     */
    void compile(String input);
}
