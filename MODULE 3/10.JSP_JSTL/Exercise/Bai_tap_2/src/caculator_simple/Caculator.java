package caculator_simple;

public class Caculator {
    public static double caculator(double a, double b, String operator){
        double result = 0;
            if (operator.equals("plus")){
                result = a+b;
            }else if (operator.equals("sub")){
                result=a-b;
            } else if (operator.equals("mul")){
                result = a*b;
            } else if (operator.equals("div")){
                result = a/b;
            }
        return result;
    }
}
