package Commons;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    public static final String SDT_REGET = "^0[\\d]{3} [\\d]{3} [\\d]{3}$";
    public static final String EMAIL_REGET = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)+$";
    private static Pattern pattern;
    private static Matcher matcher;
    public static boolean isValidatorID(String str,String regex){
        pattern =Pattern.compile(regex);
        matcher = pattern.matcher(str);
        boolean flag = matcher.matches();
        if (!flag){
            System.out.println("Không đúng định dạng. Vui lòng nhập lại.");
        } else {
            System.out.println("Nhập thành công.!");
        }
        return flag;
    }
}
