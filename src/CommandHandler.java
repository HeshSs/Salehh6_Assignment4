import java.text.ParseException;

/**
 * This class saves the data that was returned from PrintCommand or BlockCommand class to the database
 */
class CommandHandler {
    Database database;

    CommandHandler(Database database) {
        this.database = database;
    }

    void run(Command command) throws ParseException {
        command.run(database);
    }
}
