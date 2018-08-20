package com.javaclasses.brainfuckcompiler.impl.command.impl;

import com.javaclasses.brainfuckcompiler.impl.Compile;
import com.javaclasses.brainfuckcompiler.impl.impl.CompileImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


class IncrementCommandTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    private final Compile compilerImpl = new CompileImpl(new CommandFactory());

    {
        System.setOut(new PrintStream(outContent));
    }

    @Test
    void testIncrement() {

        compilerImpl.compile("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++.");

        Assertions.assertEquals("H", outContent.toString());
    }

    @Test
    void testIncrementAndMoverRight() {

        compilerImpl.compile("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++.>++++++++++++++++++++++++++++++++++++++++++++++++.");

        Assertions.assertEquals("H0", outContent.toString());
    }

    @Test
    void testHelloWord() {

        compilerImpl.compile("++++++++[>++++[>++>+++>+++>+<<<<-]>+>+>->>+[<]<-]>>.>---.+++++++..+++.>>.<-.<.+++.------.--------.>>+.>++.");

        Assertions.assertEquals("Hello World!", outContent.toString().trim());
    }

    @Test
    void testLoops() {

        compilerImpl.compile("+++[>++++[>+++[>++>+++>+<<<-]<-]<-]>>>++++.>+++..+.+++.>---.");

        Assertions.assertEquals("Loops!", outContent.toString().trim());
    }
}