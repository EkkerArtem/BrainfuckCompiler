package com.javaclasses.brainfuckcompiler.impl.command.impl;

import com.javaclasses.brainfuckcompiler.impl.CommandExeption;
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
    void testIncrement() throws CommandExeption {
        compilerImpl.read("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++.");
        compilerImpl.compile();

        Assertions.assertEquals("H", outContent.toString());
    }

    @Test
    void testsdent() throws CommandExeption {
        compilerImpl.read("?");
        Assertions.assertThrows(NullPointerException.class, compilerImpl::compile);
    }

    @Test
    void testMultiCompileCheck() throws CommandExeption {

        compilerImpl.read("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++.>++++++++++++++++++++++++++++++++++++++++++++++++.");
        compilerImpl.compile();
        compilerImpl.compile();
        compilerImpl.compile();
        compilerImpl.compile();
        compilerImpl.compile();

        Assertions.assertEquals("H0H0H0H0H0", outContent.toString());
    }

    @Test
    void testHelloWord() throws CommandExeption {

        compilerImpl.read("++++++++[>++++[>++>+++>+++>+<<<<-]>+>+>->>+[<]<-]>>.>---.+++++++..+++.>>.<-.<.+++.------.--------.>>+.>++.");
        compilerImpl.compile();

        Assertions.assertEquals("Hello World!", outContent.toString().trim());
    }

    @Test
    void testLoops() throws CommandExeption {

        compilerImpl.read("+++[>++++[>+++[>++>+++>+<<<-]<-]<-]>>>++++.>+++..+.+++.>---.");
        compilerImpl.compile();

        Assertions.assertEquals("Loops!", outContent.toString().trim());
    }
}