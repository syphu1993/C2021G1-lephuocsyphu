package Commons;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    public static final String IDVNCUSTOMER_REGET = "^KHVN-[\\d]{5}$";
    public static final String IDFORCUSTOMER_REGET = "^KHNN-[\\d]{5}$";
    private static Pattern pattern;
    private static Matcher matcher;
    public static boolean isValidatorID(String str,String regex){
        pattern =Pattern.compile(regex);
        matcher = pattern.matcher(str);
        boolean flag = matcher.matches();
        if (!flag){
            System.out.println("Không đúng định dạng :"+IDVNCUSTOMER_REGET+" or "+IDFORCUSTOMER_REGET);
        }
        return flag;
    }
}
