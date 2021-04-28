package STRING_REGEX.BAI_TAP;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ClassName {
    private static final String regex ="^[CAP]{1}\\d{4}[GHIKLM]$";

    public ClassName() {
    }
    public static boolean checkName(String str){
        Pattern pattern = Pattern.compile(regex);
        Matcher match = pattern.matcher(str);
        return match.matches();
    }
}
