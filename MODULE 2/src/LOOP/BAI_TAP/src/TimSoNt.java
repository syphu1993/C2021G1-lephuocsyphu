public class TimSoNt {
    public static void main(String[] args) {
        int n=0;
        boolean check=false;
        while (n<1000){
            if(n<2){
                check = false;
            } else if (n>=2){
                check = true;
                for (int i = 2; i <=Math.sqrt(n) ; i++) {
                    if(n%i==0){
                        check = false;
                        break;
                    }
                }
            } if(check){
                System.out.print(n+";");
            } n++;
        }
    }
}
