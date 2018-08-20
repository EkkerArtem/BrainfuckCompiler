package com.javaclasses.brainfuckcompiler.impl.command.impl;

import com.javaclasses.brainfuckcompiler.impl.command.BrainfuckCommands;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class for performing the brainfuck language increment operation.
 * It increments the byte at the data pointer.
 * See {@link BrainfuckCommands} "+" character.
 */
public class IncrementCommand implements BrainfuckCommands {

    private static final Logger log = LoggerFactory.getLogger(IncrementCommand.class);

    @Override
    public void perform(InstructionPointer instructionPointer) {
        instructionPointer.getMemory()[instructionPointer.getDataPointer()]++;

        log.debug("Value incremented");
    }
}
