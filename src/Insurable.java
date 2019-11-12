import java.util.HashMap;

/**
 * The Insurable class is a superclass for anything that is insurable and it's subclasses are Home and Car.
 */
class Insurable {
    protected String ownerName;
    protected long value;

    /**
     * The Insurable constructor assigns the object it's owner's name and it's value.
     */
    Insurable(HashMap<String, Tag> tags) {
        ownerName = tags.get("OWNER_NAME").getValue();
        value = Long.parseLong(tags.get("VALUE").getValue());
    }

    public String getOwnerName() {
        return ownerName;
    }

    public long getValue() {
        return value;
    }
}
