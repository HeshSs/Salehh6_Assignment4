import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        try {
            InputReader inputReader = InputReader.getInstance();                /* Creates a new InputReader() */
            ArrayList<Command> commands = inputReader.getCommands();            /* Creates a ArrayList of all the inputted commands */
            Iterator<Command> currentCommand = commands.iterator();             /* Iterates through each command */

            CommandHandler commandHandler = new CommandHandler(new Database()); /* Creates a database to store the data from commands */

            // while command FINISH is not entered keep adding the commands to the database
            while (currentCommand.hasNext()) {
                commandHandler.run(currentCommand.next());
            }
        } catch (ParseException e) {                    /* Catch any ParseException and output it's message */
            System.out.println(e.getMessage());
        } catch (BadCommandException e) {               /* Catch any BadCommandException and output it's message */
            System.out.println(e.getMessage());
        }
    }
}
