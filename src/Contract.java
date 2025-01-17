import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;

/**
 * The Contract class processes a contract and contains it's info (e.g. customer name or the plan that the contract is under etc.)
 */
class Contract {
    private String contractName;
    private String customerName;
    private String planName;
    private Date startDate;
    private Date endDate;
    private int discountPercentage;

    static final String inputTag = "CONTRACT";

    /**
     * The Contract constructor creates a Contract object from the inputted info
     */
    Contract(HashMap<String, Tag> tags) throws ParseException {
        contractName = tags.get("CONTRACT_NAME").getValue();
        customerName = tags.get("CUSTOMER_NAME").getValue();
        planName = tags.get("PLAN_NAME").getValue();
        startDate = Utils.convertDate(tags.get("START_DATE").getValue());
        endDate = Utils.convertDate(tags.get("END_DATE").getValue());
        discountPercentage = Integer.parseInt(tags.get("DISCOUNT_PERCENTAGE").getValue());
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getPlanName() {
        return planName;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public int getDiscountPercentage() {
        return discountPercentage;
    }

    public static String getInputTag() {
        return inputTag;
    }

    public String getContractName() {
        return contractName;
    }
}
