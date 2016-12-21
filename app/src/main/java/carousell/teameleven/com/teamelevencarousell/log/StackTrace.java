package carousell.teameleven.com.teamelevencarousell.log;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * Created by LMP on 21/12/2016.
 */

public class StackTrace {
    public static String trace(Exception ex) {
        StringWriter outStream = new StringWriter();
        ex.printStackTrace(new PrintWriter(outStream));
        return outStream.toString();
    }
}