package com.javaclasses.brainfuckcompiler.impl.command.impl;

import com.javaclasses.brainfuckcompiler.impl.command.BrainfuckCommands;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class for performing the brainfuck language move right operation.
 * It increments the data pointer (to point to the next cell to the right).
 * See {@link BrainfuckCommands} ">" character.
 */
public class MoveRightCommand implements BrainfuckCommands {

    private static final Logger log = LoggerFactory.getLogger(MoveRightCommand.class);

    @Override
    public void performOperation(InstructionPointer instructionPointer) {
        if (instructionPointer.getDataPointer() == instructionPointer.getLength() - 1) {
            instructionPointer.setDataPointer(0);
            log.debug("Moved left");
        } else {
            instructionPointer.setDataPointer(instructionPointer.getDataPointer() + 1);
        }
        log.debug("Moved left");
    }
}
