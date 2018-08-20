package com.javaclasses.brainfuckcompiler.impl.command;

import com.javaclasses.brainfuckcompiler.impl.command.impl.InstructionPointer;

/**
 * An interface for performing brainfuck language operations.
 * It moves instruction pointer and perform brainfuck operations one by one.
 * <p>
 * It supports such operations as :
 * ">" increment the data pointer (to point to the next cell to the right),
 * "<" decrement the data pointer (to point to the next cell to the left).
 * "+" increment (increase by one) the byte at the data pointer.
 * "-" decrement (decrease by one) the byte at the data pointer.
 * "." output the byte at the data pointer.
 * "[" if the byte at the data pointer is zero, then instead of moving the instruction pointer
 * forward to the next command, jump it forward to the command after the matching ] command.
 * "]" if the byte at the data pointer is nonzero, then instead of moving the instruction pointer
 * forward to the next command, jump it back to the command after the matching [ command.
 */
public interface BrainfuckCommands {
    /**
     * Method for performing brainfuck language operations {@link BrainfuckCommands}.
     *
     * @param instructionPointer instruction pointer that stores information needed to perform brainfuck operations
     *                           like data pointer position and current char on inputted brainfuck code.
     */
    void compile(InstructionPointer instructionPointer);
}
