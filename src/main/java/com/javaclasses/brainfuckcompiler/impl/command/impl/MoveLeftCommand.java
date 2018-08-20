package com.javaclasses.brainfuckcompiler.impl.command.impl;

import com.javaclasses.brainfuckcompiler.impl.command.BrainfuckCommands;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class for performing the brainfuck language move left operation.
 * It decrements the data pointer (to point to the next cell to the left).
 * See {@link BrainfuckCommands} "<" character.
 */
public class MoveLeftCommand implements BrainfuckCommands {

    private static final Logger log = LoggerFactory.getLogger(MoveLeftCommand.class);

    @Override
    public void perform(InstructionPointer instructionPointer) {
        if (instructionPointer.getDataPointer() == 0) {
            instructionPointer.setDataPointer(instructionPointer.getLength() - 1);
            log.debug("Moved left");
        } else {
            instructionPointer.setDataPointer(instructionPointer.getDataPointer() - 1);
        }
        log.debug("Moved left");
    }
}
