package com.javaclasses.brainfuckcompiler.impl.command.impl;

import com.javaclasses.brainfuckcompiler.impl.command.BrainfuckCommands;

import java.util.HashMap;
import java.util.Map;

public class CommandFactory {

    private final Map<Character, BrainfuckCommands> commands = new HashMap<>();

    public CommandFactory() {
        commands.put('+', new IncrementCurrentValue());
        commands.put('.', new OutputCommand());
    }

    public BrainfuckCommands getCommand(Character command) {
        return commands.get(command);
    }
}
