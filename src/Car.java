import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;

/**
 * The Car class contains the info of the car (e.g. it's make, model etc) and it's setters and getters
 */
class Car extends Insurable {

    private String make;
    private String model;
    private Date purchaseDate;
    private long mileage;
    static final String inputTag = "CAR";

    /**
     * The Car constructor creates a car object with the given info of the car
     */
    Car(HashMap<String, Tag> tags) throws ParseException {
        super(tags);
        make = tags.get("MAKE").getValue();
        model = tags.get("MODEL").getValue();
        purchaseDate = Utils.convertDate(tags.get("PURCHASE_DATE").getValue());
        mileage = Long.parseLong(tags.get("MILEAGE").getValue());
    }

    public String getOwnerName() {
        return ownerName;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public long getMileage() {
        return mileage;
    }

    public static String getInputTag() {
        return inputTag;
    }
}

