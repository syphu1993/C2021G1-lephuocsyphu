package STRING_REGEX.THUC_HANH;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ViDu {
    public static void main(String[] args) {
        String str = "Welcometgprco-der";

        // Ký tự bất kỳ xuất hiện nhiều lần lần và kết thúc là r
        String regex = "\\w*?r";

        // Tạo đối tượng Pattern thông qua method tĩnh.
        Pattern pattern = Pattern.compile(regex);

        // Lấy ra đối tượng Matcher
        Matcher matcher = pattern.matcher(str);

        // Kiểm tra có khơp với regex không
        boolean match = matcher.matches();
        System.out.println("Match = " + match); // Match = true
    }

}
