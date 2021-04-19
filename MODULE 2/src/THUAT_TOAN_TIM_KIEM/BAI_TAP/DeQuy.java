package THUAT_TOAN_TIM_KIEM.BAI_TAP;

public class DeQuy {
    public static int timKiemDeQuy(int[] array, int left, int right, int key) {
        if (left <= right) {
           int mid = (left + right) / 2;
            if (array[mid] == key) {
                return mid;
            }
             else if (key < array[mid]) {
                int newright = mid -1;
                return timKiemDeQuy(array, left, newright, key);
            } else {
                int newleft = mid +1;
                return timKiemDeQuy(array, newleft, right, key);
            }
        }
            return -1;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(timKiemDeQuy(array, 0, 8, 9));
    }
}
