package convert.service.impl;

import convert.service.IConvert;
import org.springframework.stereotype.Service;

@Service
public class ConvertImpl implements IConvert {
    @Override
    public double convertCash(double usd, double rate) {
        double result = usd*rate;
        return  result;
    }
}
