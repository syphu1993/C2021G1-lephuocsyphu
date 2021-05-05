package Commons;

public class ConverUtils {
    public static String nomallizeString(String str){
        StringBuilder stringBuilder =new StringBuilder(str.substring(0,1).toUpperCase());
        stringBuilder.append(str.substring(1).toLowerCase());
        return stringBuilder.toString();
    }
}
