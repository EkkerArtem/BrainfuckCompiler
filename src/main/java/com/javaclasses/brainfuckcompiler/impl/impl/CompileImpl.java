package com.javaclasses.brainfuckcompiler.impl.impl;

import com.javaclasses.brainfuckcompiler.impl.Compile;
import com.javaclasses.brainfuckcompiler.impl.command.impl.CommandFactory;
import com.javaclasses.brainfuckcompiler.impl.command.impl.InstructionPointer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CompileImpl implements Compile {
    private CommandFactory commandDispatcher;

    public CompileImpl(CommandFactory commandDispatcher) {
        this.commandDispatcher = commandDispatcher;
    }

    private static final Logger log = LoggerFactory.getLogger(CompileImpl.class);

    @Override
    public void compile(String input) {

        log.info("Inputted string have been read");

        InstructionPointer instructionPointer = new InstructionPointer(65555, input);

        while (input.length() > instructionPointer.getCurrentChar()) {
            commandDispatcher.getCommand(input.charAt(instructionPointer.getCurrentChar())).perform(instructionPointer);
            instructionPointer.setCurrentChar(instructionPointer.getCurrentChar() + 1);
        }
        log.info("Result obtained");
    }
}
