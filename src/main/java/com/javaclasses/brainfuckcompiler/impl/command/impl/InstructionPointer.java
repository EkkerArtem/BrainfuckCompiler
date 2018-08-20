package com.javaclasses.brainfuckcompiler.impl.command.impl;

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
