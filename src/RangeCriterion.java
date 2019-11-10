/**
 * The RangeCriterion class handles all the LARGER or SMALLER relations for the HomePlan and CarPlan classes
 * (e.g. CAR.MILEAGE, HOME.VALUE, CUSTOMER.INCOME etc.)
 */
class RangeCriterion {
    private long maxValue = Long.MAX_VALUE;
    private long minValue = Long.MIN_VALUE;

    void addCriterion(Tag tag) {
        if (tag.getRelation() == Tag.Relation.LARGER) {
            minValue = Math.max(minValue, Long.parseLong(tag.getValue()));
        }
        if (tag.getRelation() == Tag.Relation.SMALLER) {
            maxValue = Math.min(maxValue, Long.parseLong(tag.getValue()));
        }
    }

    // Calculates if the value of a car or house is in the required range for the plan
    boolean isInRange(long value) {
        if (value < maxValue && value > minValue)
            return true;
        return false;
    }
}
