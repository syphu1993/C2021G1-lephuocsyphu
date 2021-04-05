package CLASS_OBJECT.BAI_TAP;

import java.lang.reflect.Array;
import java.util.Arrays;

public class CountTIme {
    public static void main(String[] args) {
        double[] array = new double[100000];
        for (int i = 0; i <100000 ; i++) {
          array[i]= (double)Math.random()*100;
        }
        StopWatch count = new StopWatch();
        count.start();
        Arrays.sort(array);
        count.stop();
        System.out.println(count.getElapsedTime());
    }
}
