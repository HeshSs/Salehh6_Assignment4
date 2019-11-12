import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;

/**
 * The Customer class creates a costumer so that all the other classes can get the costumer's info
 */
class Customer {
    private String name;
    private Date dateOfBirth;
    private long income;

    static final String inputTag = "CUSTOMER";

    /**
     * The Customer constructor creates a Customer object from the inputted info
     */
    Customer(HashMap<String, Tag> tags) throws ParseException {
        name = tags.get("NAME").getValue();
        dateOfBirth = Utils.convertDate(tags.get("DATE_OF_BIRTH").getValue());
        income = Long.parseLong(tags.get("INCOME").getValue());
    }

    public String getName() {
        return name;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public long getIncome() {
        return income;
    }

    public static String getInputTag() {
        return inputTag;
    }
}
