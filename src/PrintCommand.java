/**
 * The PrintCommand class handles all the commands that start with PRINT and outputs it's message.
 */
class PrintCommand extends Command {
    private String entityType;
    private String queryType;
    private String queryValue;

    /**
     * Gets a list of tokens from the makePrintCommand and creates variables out of each token.
     * @param tokens A list of String tokens.
     */
    PrintCommand(String[] tokens) {
        super();
        entityType = tokens[1];
        queryType = tokens[2];
        queryValue = tokens[3];
    }

    //Processes the PRINT COSTUMER, PRINT PLAN command or throws an exception.
    @Override
    void run(Database database) {
        if (entityType.equals("CUSTOMER"))
            runPrintCustomer(database);
        else if (entityType.equals("PLAN"))
            runPrintPlan(database);
        else {
            throw new BadCommandException("Bad print command.");
        }
    }

    // Processes the TOTAL_CLAIMED or TOTAL_RECEIVED command and prints the output.
    private void runPrintCustomer(Database database) {
        if (queryType.equals("TOTAL_CLAIMED")) {
            System.out.println("Total amount claimed by " + database.getCustomer(queryValue).getName() +
                    " is " + database.totalClaimAmountByCustomer(queryValue));
        } else if (queryType.equals("TOTAL_RECEIVED")) {
            System.out.println("Total amount received by " + database.getCustomer(queryValue).getName() +
                            " is " + database.totalReceivedAmountByCustomer(queryValue));
        }
    }

    // Processes the NUM_CUSTOMERS or TOTAL_PAYED_TO_CUSTOMERS command and prints the output.
    private void runPrintPlan(Database database) {
        if (queryType.equals("NUM_CUSTOMERS")) {
            System.out.println("Number of customers under " + database.getPlan(queryValue).getName() +
                    " is " + database.numberOfCustomers(queryValue));
        } else if (queryType.equals("TOTAL_PAYED_TO_CUSTOMERS")) {
            System.out.println("Total amount payed under " + database.getPlan(queryValue).getName() +
                    " is " + database.totalPaidToCostumers(queryValue));
        }

    }
}
