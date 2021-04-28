package STRING_REGEX.THUC_HANH;

public class EmailExampleTest {
    private static EmailExample emailExample;
    public static final String[] validEmail = new String[] { "a@gmail.com.vn", "ab@yahoo.com.vn", "abc@hotmail.com.vn" };
    public static final String[] invalidEmail = new String[] { "@gmail.com", "ab@gmail.", "@#abc@gmail.com" };

    public static void main(String args[]) {
        emailExample = new EmailExample();
        for (String email : validEmail) {
            boolean isvalid = emailExample.validate(email);
            System.out.println("Email is " + email +" is valid: "+ isvalid);
        }
        for (String email : invalidEmail) {
            boolean isvalid = emailExample.validate(email);
            System.out.println("Email is " + email +" is valid: "+ isvalid);
        }
    }
}
