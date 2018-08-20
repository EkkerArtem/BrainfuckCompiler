package com.javaclasses.brainfuckcompiler.impl.command.impl;

import com.javaclasses.brainfuckcompiler.impl.CommandException;
import com.javaclasses.brainfuckcompiler.impl.Compile;
import com.javaclasses.brainfuckcompiler.impl.impl.CompileImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


class CommandTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    private final Compile compilerImpl = new CompileImpl(new CommandFactory());

    {
        System.setOut(new PrintStream(outContent));
    }

    @Test
    void testIncrement() throws CommandException {
        compilerImpl.read("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++.");
        compilerImpl.compile();

        Assertions.assertEquals("H", outContent.toString());
    }

    @Test
    void testsdent() throws CommandException {
        compilerImpl.read("?");
        Assertions.assertThrows(CommandException.class, compilerImpl::compile);

    }

    @Test
    void testMultiCompileCheck() throws CommandException {

        compilerImpl.read("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++.>++++++++++++++++++++++++++++++++++++++++++++++++.");
        compilerImpl.compile();
        compilerImpl.compile();
        compilerImpl.compile();
        compilerImpl.compile();
        compilerImpl.compile();

        Assertions.assertEquals("H0H0H0H0H0", outContent.toString());
    }

    @Test
    void testHelloWord() throws CommandException {

        compilerImpl.read("++++++++[>++++[>++>+++>+++>+<<<<-]>+>+>->>+[<]<-]>>.>---.+++++++..+++.>>.<-.<.+++.------.--------.>>+.>++.");
        compilerImpl.compile();

        Assertions.assertEquals("Hello World!", outContent.toString().trim());
    }

    @Test
    void testLoops() throws CommandException {

        compilerImpl.read("+++[>++++[>+++[>++>+++>+<<<-]<-]<-]>>>++++.>+++..+.+++.>---.");
        compilerImpl.compile();

        Assertions.assertEquals("Loops!", outContent.toString().trim());
    }
}