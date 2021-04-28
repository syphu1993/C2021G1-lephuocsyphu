package STRING_REGEX.BAI_TAP;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ClassPhone {
    private static final String regex ="^\\(\\d{2}\\)-\\(0\\d{9}\\)$";

    public ClassPhone() {
    }

    public static boolean checkNumber(String str){
        Pattern pattern = Pattern.compile(regex);
        Matcher match = pattern.matcher(str);
        return match.matches();
    }
}
