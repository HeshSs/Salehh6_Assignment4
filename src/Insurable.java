import java.util.HashMap;

/**
 * The Insurable class is a superclass for Home and Car and contains the info about their insurance
 */
class Insurable {
    protected String ownerName;
    protected long value;

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
