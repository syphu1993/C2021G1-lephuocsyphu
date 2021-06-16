package caculator.service.iplm;

import caculator.service.ICaculator;
import org.springframework.stereotype.Service;

@Service
public class CaculatorImpl implements ICaculator {

    @Override
    public double caculate(double a, double b, String operate) {
        double result = 0;
        if (operate.equals("Add(+)")){
            result = a+b;
        } else if (operate.equals("Sub(-)")){
            result =a-b;
        } else if (operate.equals("Mul(*)")){
            result = a*b;
        }else if (operate.equals("Div(/)")){
            try {
                result = a/b;
            } catch (Exception e){
                e.getMessage();
            }
        }
        return result;
    }
}
