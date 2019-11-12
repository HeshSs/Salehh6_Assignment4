import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;

/**
 * The Utils class has methods that converts a String date to Date Object with "yyyy-MM-dd" format.
 */
class Utils {

    private static SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

    /**
     * Converts a String date with "yyyy-MM-dd" format to Date object.
     * @param input date in "yyyy-MM-dd" format.
     * @return Date object of the date.
     */
    static Date convertDate(String input) throws ParseException {
        return formatter.parse(input);
    }

    /**
     * Converts a Date to a formatted String with "yyyy-MM-dd" format.
     * @param date a Date object.
     * @return String in "yyyy-MM-dd" format.
     */
    static String formattedDate(Date date) {
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        return simpleDateFormat.format(date);
    }
}
