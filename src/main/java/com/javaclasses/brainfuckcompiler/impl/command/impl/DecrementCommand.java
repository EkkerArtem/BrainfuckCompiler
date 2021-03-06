package com.javaclasses.brainfuckcompiler.impl.command.impl;

import com.javaclasses.brainfuckcompiler.impl.command.BrainfuckCommands;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class for performing the brainfuck language decrement operation.
 * It decrements the byte at the data pointer.
 * See {@link BrainfuckCommands} "-" character.
 */
public class DecrementCommand implements BrainfuckCommands {

    private static final Logger log = LoggerFactory.getLogger(IncrementCommand.class);

    @Override
    public void performOperation(InstructionPointer instructionPointer) {
        instructionPointer.getMemory()[instructionPointer.getDataPointer()]--;

        log.debug("Value decremented");
    }
}
