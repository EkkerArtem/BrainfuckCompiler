package com.javaclasses.brainfuckcompiler.impl.command.impl;

/**
 * Class that imitates the work of instruction pointer : an instruction pointer begins at the first command,
 * and each command it points to is executed, after which it normally moves forward to the next command.
 * The program terminates when the instruction pointer moves past the last command.
 * <p>
 * For more info see <a href="https://en.wikipedia.org/wiki/Brainfuck#Language_design"></a>.
 */
public class InstructionPointer {
    private int dataPointer;
    private int length;
    private byte[] memory;
    private String code;
    private int currentChar;

    public InstructionPointer(int length, String code) {
        this.length = length;
        this.code = code;
        this.memory = new byte[length];
    }

    public int getDataPointer() {
        return dataPointer;
    }

    public void setDataPointer(int dataPointer) {
        this.dataPointer = dataPointer;
    }

    public int getLength() {
        return length;
    }

    public byte[] getMemory() {
        return memory;
    }

    public String getCode() {
        return code;
    }

    public int getCurrentChar() {
        return currentChar;
    }

    public void setCurrentChar(int currentChar) {
        this.currentChar = currentChar;
    }

}
