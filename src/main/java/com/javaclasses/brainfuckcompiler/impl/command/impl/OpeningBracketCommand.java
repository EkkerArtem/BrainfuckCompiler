package com.javaclasses.brainfuckcompiler.impl.command.impl;

import com.javaclasses.brainfuckcompiler.impl.command.BrainfuckCommands;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class for performing the brainfuck language opening bracket operation.
 * If the byte at the data pointer is zero, then instead of moving the instruction pointer
 * forward to the next command, jump it forward to the command after the matching ] command.
 * See {@link BrainfuckCommands} "[" character.
 */
public class OpeningBracketCommand implements BrainfuckCommands {

    private static final Logger log = LoggerFactory.getLogger(OpeningBracketCommand.class);

    @Override
    public void performOperation(InstructionPointer instructionPointer) {

        if (instructionPointer.getMemory()[instructionPointer.getDataPointer()] == 0) {
            instructionPointer.setCurrentChar(instructionPointer.getCurrentChar() + 1);
        }
        log.debug("[ operation done");
    }
}
