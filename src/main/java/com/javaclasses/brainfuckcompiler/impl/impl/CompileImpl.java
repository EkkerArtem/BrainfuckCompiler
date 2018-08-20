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

    private String inputted;

    @Override
    public void read(String input) {
        StringBuilder stringBuilder = new StringBuilder();
        InstructionPointer instructionPointer = new InstructionPointer(65555, input);
        while (input.length() > instructionPointer.getCurrentChar()) {
            stringBuilder.append(input.charAt(instructionPointer.getCurrentChar()));
            instructionPointer.setCurrentChar(instructionPointer.getCurrentChar() + 1);
        }
        log.info("Inputted string have been read");
        inputted = stringBuilder.toString();
    }


    @Override
    public void compile() {


        InstructionPointer instructionPointer = new InstructionPointer(65555, inputted);

        while (inputted.length() > instructionPointer.getCurrentChar()) {

            commandDispatcher.getCommand(inputted.charAt(instructionPointer.getCurrentChar())).perform(instructionPointer);
            instructionPointer.setCurrentChar(instructionPointer.getCurrentChar() + 1);
        }
        log.info("Result obtained");
    }
}
