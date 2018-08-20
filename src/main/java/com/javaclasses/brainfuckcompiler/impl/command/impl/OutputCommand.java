package com.javaclasses.brainfuckcompiler.impl.command.impl;

import com.javaclasses.brainfuckcompiler.impl.command.BrainfuckCommands;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OutputCommand implements BrainfuckCommands {

    private static final Logger log = LoggerFactory.getLogger(OutputCommand.class);

    @Override
    public void perform(InstructionPointer instructionPointer) {
        char curentResult = (char) (instructionPointer.getMemory()[instructionPointer.getDataPointer()]);
        System.out.print(curentResult);

        log.debug("Current position value displayed");
    }
}
