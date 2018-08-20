package com.javaclasses.brainfuckcompiler.impl.command.impl;

import com.javaclasses.brainfuckcompiler.impl.command.BrainfuckCommands;

import java.util.HashMap;
import java.util.Map;

public class CommandFactory {

    private final Map<Character, BrainfuckCommands> commands = new HashMap<>();

    public CommandFactory() {
        commands.put('+', new IncrementCommand());
        commands.put('.', new OutputCommand());
        commands.put('-', new DecrementCommand());
        commands.put('>', new MoveRightCommand());
        commands.put('<', new MoveLeftCommand());
    }

    public BrainfuckCommands getCommand(Character command) {
        return commands.get(command);
    }
}
