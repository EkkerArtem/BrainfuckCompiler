package com.javaclasses.brainfuckcompiler.impl.command.impl;

import com.javaclasses.brainfuckcompiler.impl.command.BrainfuckCommands;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class IncrementCurrentValue implements BrainfuckCommands {

    private static final Logger log = LoggerFactory.getLogger(IncrementCurrentValue.class);

    @Override
    public void perform(InstructionPointer instructionPointer) {
        instructionPointer.getMemory()[instructionPointer.getDataPointer()]++;

        log.debug("Value incremented");
    }
}
