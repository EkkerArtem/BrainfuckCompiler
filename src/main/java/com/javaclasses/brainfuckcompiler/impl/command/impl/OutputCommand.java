package com.javaclasses.brainfuckcompiler.impl.command.impl;

import com.javaclasses.brainfuckcompiler.impl.command.BrainfuckCommands;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class for performing the brainfuck language output operation.
 * It outputs the byte at the data pointer.
 * See {@link BrainfuckCommands} "." character.
 */
public class OutputCommand implements BrainfuckCommands {

    private static final Logger log = LoggerFactory.getLogger(OutputCommand.class);

    @Override
    public void perform(InstructionPointer instructionPointer) {
        char result = (char) (instructionPointer.getMemory()[instructionPointer.getDataPointer()]);
        System.out.print(result);

        log.debug("Current position value displayed");
    }
}
