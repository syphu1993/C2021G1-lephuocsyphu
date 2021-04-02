public class inSoNguyenTo {
    public static void main(String[] args) {
        int n=0;
        int count = 0;
        boolean check=false;
        while (count<20){
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
                System.out.println(n);
                count++;
            } n++;
        }
    }
}
