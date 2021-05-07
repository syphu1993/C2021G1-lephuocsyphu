package Common;

public class StringUtils {
    public static final String COMMA =",";
    public static final String CSV = ".csv";
    public static String concat(String[] content,String character ){
        StringBuffer stringBuffer = new StringBuffer(content[0]);
        for (int i = 1; i <content.length ; i++) {
            stringBuffer.append(character);
            stringBuffer.append(content[i]);
        }
        return stringBuffer.toString();
    }
}