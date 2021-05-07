package Common;

import Exeption.ExceptionCodeTransport;
import Model.Transport;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    private static Pattern pattern;
    private static Matcher matcher;
    public static final String CODE_TRUCK_REGET = "[\\d]{2}C-[\\d]{3}.[\\d]{2}";
    public static final String CODE_CAR_REGET = "[\\d]{2}[A|B]-[\\d]{3}.[\\d]{2}";
    public static final String CODE_MOTO_REGET = "[\\d]{2}-[A-Z]{1}[\\d|A-Z]{1}-[\\d]{3}.[\\d]{2}";

    public static boolean isValidator(String str, String regex) {
        pattern = Pattern.compile(regex);
        matcher = pattern.matcher(str);
        boolean flag = matcher.matches();
        if (!flag) {
            System.out.println(" Không đúng định dạnh + Xe tải: XXC-XXX.XX (X : 0÷9)\n" +
                    "+ Ôtô: XXY-XXX.XX (X : 0÷9 , Y=A nếu xe du lịch, Y=B  nếu xe khách)\n" +
                    "+ Xe máy: XX-YZ-XXX.XX (X : 0÷9, Y= (Chữ cái in hoa), Z =(0÷9) hoặc (Chữ cái in Hoa).\n");
        }
        return flag;
    }

    public static boolean isSameCode(List<Transport> list, String str) {
        boolean flag = false;
        for (Transport transport : list) {
            if ((transport.getBienKiemSoat()).equals(str)) {
                flag = true;
                break;
            }
        }
        if (flag) {
            System.out.println("Nhập lại biển kiểm soát.");
        }
        return flag;
    }
    public static void isCodeTruck(String code) throws ExceptionCodeTransport {
        if (!Validator.isValidator(code,Validator.CODE_TRUCK_REGET)){
            throw new ExceptionCodeTransport();
        }
    }
    public static void isCodeCar(String code) throws ExceptionCodeTransport {
        if (!Validator.isValidator(code,Validator.CODE_CAR_REGET)){
            throw new ExceptionCodeTransport();
        }
    }
    public static void isCodeMoto(String code) throws ExceptionCodeTransport {
        if (!Validator.isValidator(code,Validator.CODE_MOTO_REGET)){
            throw new ExceptionCodeTransport();
        }
    }
}
