package THUAT_TOAN_TIM_KIEM.THUC_HANH;

public class TimKiemNhiPhan {
    public static int timKiemPhanTu(int[] arr, int key ){
        int left =0;
        int right = arr.length-1;
        int mid;
        while (left<=right){
           mid = (left+right)/2;
        if (key == arr[mid]){
            return mid;
        } else if (key<arr[mid]){
            right =mid-1;
        } else  if (key>arr[(left+right)/2]){
            left= mid+1;
        }
    }return -1;
}

    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7,8,9};
        System.out.println(timKiemPhanTu(array, 1));
    }
}
