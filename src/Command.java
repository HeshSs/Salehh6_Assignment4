import java.text.ParseException;

/**
 * This creates an abstract class Command so that other classes like CommandHandler, BlockCommand and PrintCommand
 * can implement their own commands and run method
 */
abstract class Command {
    abstract void run(Database database) throws ParseException;
}
