package com.javaclasses.brainfuckcompiler;

/**
 *An interface for compiling input, written on brainfuck language. See <a href="https://en.wikipedia.org/wiki/Brainfuck"></a>.
 *It will translate, compile and return result of brainfuck code inputted.
 */
public interface BrainfuckCompiler {

    /**
     * Return the result of compiling the brainfuck code.
     * @param inputData is an inputted brainfuck code.
     */
    void interpret(String inputData);
}
