package com.javaclasses.brainfuckcompiler.impl.command.impl;

import com.javaclasses.brainfuckcompiler.impl.CommandExeption;
import com.javaclasses.brainfuckcompiler.impl.command.BrainfuckCommands;

import java.util.HashMap;
import java.util.Map;

public class CommandFactory {

    public static final Character CLOSING_BRACKET = ']';
    public static final Character OPENING_BRACKET = '[';

    private final Map<Character, BrainfuckCommands> commands = new HashMap<>();

    public CommandFactory() {
        commands.put('+', new IncrementCommand());
        commands.put('.', new OutputCommand());
        commands.put('-', new DecrementCommand());
        commands.put('>', new MoveRightCommand());
        commands.put('<', new MoveLeftCommand());
        commands.put(OPENING_BRACKET, new OpeningBracketCommand());
        commands.put(CLOSING_BRACKET, new ClosingBracketCommand());
    }

    public BrainfuckCommands getCommand(Character command) throws CommandExeption {
        if (!commands.containsKey(command)) {
            throw new CommandExeption("No such command found");
        }
        return commands.get(command);
    }
}
