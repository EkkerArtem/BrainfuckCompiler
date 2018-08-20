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
public class OppeningBracketCommand implements BrainfuckCommands {

    private static final Logger log = LoggerFactory.getLogger( OppeningBracketCommand.class );

    @Override
    public void perform(InstructionPointer instructionPointer) {
        int countOfBrackets = 0;

        if (instructionPointer.getMemory()[instructionPointer.getDataPointer()] == 0) {
            instructionPointer.setCurrentChar(instructionPointer.getCurrentChar() + 1);
            while (countOfBrackets > 0 || instructionPointer.getCode().charAt(instructionPointer.getCurrentChar()) != CommandFactory.CLOSING_BRACKET) {
                if (instructionPointer.getCode().charAt(instructionPointer.getCurrentChar()) == CommandFactory.OPENING_BRACKET)
                    countOfBrackets++;
                else if (instructionPointer.getCode().charAt(instructionPointer.getCurrentChar()) == CommandFactory.CLOSING_BRACKET)
                    countOfBrackets--;
                instructionPointer.setCurrentChar(instructionPointer.getCurrentChar() + 1);
            }
        } log.debug("[ operation done");
    }
}
