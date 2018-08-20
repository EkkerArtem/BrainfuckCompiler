package com.javaclasses.brainfuckcompiler.impl.command.impl;

import com.javaclasses.brainfuckcompiler.impl.Compile;
import com.javaclasses.brainfuckcompiler.impl.impl.CompileImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


class IncrementCurrentValueTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    private final Compile compilerImpl = new CompileImpl(new CommandFactory());

    {
        System.setOut(new PrintStream(outContent));
    }

    @Test
    void testIncrementValue() {

        compilerImpl.compile("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++.");

        Assertions.assertEquals("H", outContent.toString());
    }
}