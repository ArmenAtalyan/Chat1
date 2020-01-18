package utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    public static String formatDate(Date date) {
        return new SimpleDateFormat("mm-dd-yyyy hh:mm:ss").format(date);
    }

}
