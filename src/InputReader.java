import java.util.ArrayList;
import java.util.Scanner;

/**
 * Processes what the user inputted and assigns each command to it's specific class (BlockCommand or PrintCommand)
 */
class InputReader {
    private Scanner keyboard;
    private static InputReader instance = null;
    private int lineNumber = 0;

    /**
     * Starts reading user input on call using Scanner
     */
    private InputReader() {
        keyboard = new Scanner(System.in);
    }

    /**
     * Creates a new instance of InputReader()
     * @return new InputReader()
     */
    static InputReader getInstance() {
        if (instance == null) {
            instance = new InputReader();
        }
        return instance;
    }

    /**
     * If the command is valid (e.g. PRINT, BEGIN_ or FINISH) add it to the ArrayList of commands
     * @return ArrayList containing all the inputted commands
     */
    ArrayList<Command> getCommands() {
        ArrayList<Command> commands = new ArrayList<>();
        String line = "";
        lineNumber = 0;

        try {
            while (keyboard.hasNext()) {
                lineNumber++;
                line = keyboard.nextLine();
                if (line.startsWith("PRINT ")) {
                    commands.add(makePrintCommand(line));
                } else if (line.startsWith("BEGIN_")) {
                    commands.add(makeBlockCommand(line));
                } else if (line.equals("FINISH")) {
                    break;
                } else if (!line.equals("")) {
                    System.out.println(line);
                    throw new BadCommandException("Invalid command.");
                }
            }
        } catch (BadCommandException e) {
            throw new BadCommandException("Line " + lineNumber + " : " + e.getMessage());
        }
        return commands;
    }

    /**
     * Creates a BlockCommand from the inputted line
     * @param line Given a command (e.g. CONTRACT, CLAIM, HOME_PLAN etc.)
     * @return a BlockCommand
     */
    private Command makeBlockCommand(String line) {
        // Removes "BEGIN_" from the current line to get the command type;
        BlockCommand command = new BlockCommand(line.substring(6));

        while (keyboard.hasNext()) {
            lineNumber ++;
            line = keyboard.nextLine();
            if (line.equals("END_" + command.getBlockType())) {
                return command;
            } else if (line.equals("")) {
            }
            else {
                String [] tokens = line.split(" ", 3);
                if (tokens.length != 3 || tokens[1].length() != 1)
                    throw new BadCommandException("Invalid tag.");
                command.addTag(new Tag(tokens));
            }
        }
        return command;
    }

    /**
     * Converts a print command to a list of tokens for PrintCommand class
     * @param line Given a line that starts with PRINT
     * @return 3 tokens for PrintCommand to print the command
     */
    private Command makePrintCommand(String line) {
        String[] tokens = line.split(" ", 5);
        if (tokens.length > 4) {
            throw new BadCommandException("Invalid print command; too many tokens.");
        } else if (tokens.length < 4) {
                throw new BadCommandException("Invalid print command; too few tokens.");
        }
        return new PrintCommand(tokens);
    }
}