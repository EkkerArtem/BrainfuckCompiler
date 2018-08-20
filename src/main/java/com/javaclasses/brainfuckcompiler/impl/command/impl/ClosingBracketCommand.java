package com.javaclasses.brainfuckcompiler.impl.command.impl;

import com.javaclasses.brainfuckcompiler.impl.command.BrainfuckCommands;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class for performing the brainfuck language closing bracket operation.
 * if the byte at the data pointer is nonzero, then instead of moving the instruction pointer
 * forward to the next command, jump it back to the command after the matching [ command.
 * See {@link BrainfuckCommands} "]" character.
 */
public class ClosingBracketCommand implements BrainfuckCommands {

    private static final Logger log = LoggerFactory.getLogger(ClosingBracketCommand.class);

    @Override
    public void performOperation(InstructionPointer instructionPointer) {


        if (instructionPointer.getMemory()[instructionPointer.getDataPointer()] != 0) {
            instructionPointer.setCurrentChar(instructionPointer.getCurrentChar() - 1);
            innerBracketsCheck(instructionPointer);
            instructionPointer.setCurrentChar(instructionPointer.getCurrentChar() - 1);
            log.debug("[ operation done");
        }
    }

    private void innerBracketsCheck(InstructionPointer instructionPointer) {
        int countOfBrackets = 0;
        while (countOfBrackets > 0 || instructionPointer.getCode().charAt(instructionPointer.getCurrentChar()) != CommandFactory.OPENING_BRACKET) {
            if (instructionPointer.getCode().charAt(instructionPointer.getCurrentChar()) == CommandFactory.CLOSING_BRACKET) {
                countOfBrackets++;
            } else if (instructionPointer.getCode().charAt(instructionPointer.getCurrentChar()) == CommandFactory.OPENING_BRACKET) {
                countOfBrackets--;
            }
            instructionPointer.setCurrentChar(instructionPointer.getCurrentChar() - 1);
        }
    }
}

