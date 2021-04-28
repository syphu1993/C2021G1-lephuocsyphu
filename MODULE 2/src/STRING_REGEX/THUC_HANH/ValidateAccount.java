package STRING_REGEX.THUC_HANH;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateAccount {
    private static final String Regex = "^[_a-z0-9]{6,}$";

    public ValidateAccount() {
    }
    public static boolean validate(String str){
        Pattern pattern = Pattern.compile(Regex);
        Matcher match = pattern.matcher(str);
        return  match.matches();
    }
}
