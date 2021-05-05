package Commons;

import Exeption.*;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

import java.time.Year;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    public static final String SERVICE_CODE_REGEX = "SV(VL|HO|RO)-[\\d]{4}";
    public static final String SERVICE_NAME_REGEX = "[A-Z]{1}[a-z]*";
    public static final String ID_CARD_REGEX = "[\\d]{3} [\\d]{3} [\\d]{3}";
    public static final String BIRTHDAY_REGEX = "[\\d]{2}/[\\d]{2}/[\\d]{4}";

    private static Pattern pattern;
    private static Matcher matcher;

    public static boolean isValidator(String str, String regex) {
        pattern = Pattern.compile(regex);
        matcher = pattern.matcher(str);
        boolean flag = matcher.matches();
        if (!flag) {
            System.out.println("Input not match " + regex);
        }
        return flag;
    }

    public static boolean isThanMore(double number, double destNumber) {
        boolean flag = number > destNumber;
        if (!flag) {
            System.out.println("Input is not more than " + destNumber);
        }
        return flag;
    }

    public static boolean isThanMore(double number, double startNumber, double endNumber) {
        boolean flag = number > startNumber && number < endNumber;
        if (!flag) {
            System.out.println("Input is not within number.");
        }
        return flag;
    }

    public static boolean isValiExtraService(String extraServiceName) {
        String[] list = {"massage", "karaoke", "food", "drink", "car"};
        boolean flag = Arrays.asList(list).contains(extraServiceName);
        if (!flag) {
            System.out.println("Input is not name in list service.");
        }
        return flag;
    }

    public static void isValiNameCustomer(String name) throws NameException {
        String[] list = name.split(" ");
        for (String x : list) {
            if (Character.isLowerCase(x.charAt(0))) {
                throw new NameException();
            }
        }
        for (int i = 0; i < name.length() - 1; i++) {
            if (name.charAt(i) == ' ' && name.charAt(i + 1) == ' ') {
                throw new NameException();
            }
        }
    }

    public static void isValiEmailCustomer(String email) throws EmailException {
        int indexCharacter = email.indexOf('@');
        int countCharacter = 0;
        int countPoint = 0;
        if (indexCharacter < 0) {
            throw new EmailException();
        }
        for (int i = 0; i < email.length(); i++) {
            if (email.charAt(i) == '@') {
                countCharacter++;
            } else if (email.charAt(i) == '.') {
                countPoint++;
            }
        }
        if (countCharacter >= 2) {
            throw new EmailException();
        }
        if (countPoint == 0) {
            throw new EmailException();
        }
    }

    public static void isValiGender(String gender) throws GenderException {
        String[] list = {"female", "male", "unknow"};
        if (!Arrays.asList(list).contains(gender.toLowerCase())) {
            throw new GenderException();
        }
    }

    public static void isIdCardCustomer(String idCard) throws IdCardException {
        if (!Validator.isValidator(idCard, Validator.ID_CARD_REGEX)) {
            throw new IdCardException();
        }
    }

    public static void isBirthDayCustomer(String birthDay) throws BirthdayException {
        if (Validator.isValidator(birthDay, Validator.BIRTHDAY_REGEX)) {
            String[] list = birthDay.split("/");
            int birthDayNow = Integer.parseInt(list[2]);
            int dayBorn = Integer.parseInt(list[1]);
            int curYear = Year.now().getValue();
            if (birthDayNow <= 1990 || curYear - birthDayNow < 18 || dayBorn > 12) {
                throw new BirthdayException();
            }
        } else {
            throw new BirthdayException();
        }
    }
}
