package com.javaclasses.brainfuckcompiler.impl.command.impl;

import com.javaclasses.brainfuckcompiler.impl.CommandException;
import com.javaclasses.brainfuckcompiler.impl.command.BrainfuckCommands;

import java.util.HashMap;
import java.util.Map;

/**
 * Class for getting command by current char.
 * It takes the char came, compare it with chars from map
 * and return instance of class.
 */
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

    /**
     * @param command char came from expression.
     * @return command which corresponds to char came.
     * @throws CommandException if there is no command that corresponds char came.
     */
    public BrainfuckCommands getCommand(Character command) throws CommandException {
        if (!commands.containsKey(command)) {
            throw new CommandException("No such command found");
        }
        return commands.get(command);
    }
}
