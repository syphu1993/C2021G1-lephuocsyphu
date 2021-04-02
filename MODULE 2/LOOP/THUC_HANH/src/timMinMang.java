public class timMinMang {
    public static int timMinMang(int[] arr){
        int min=arr[0];
        int index=0;
        for (int i = 0; i <arr.length ; i++) {
            if (arr[i]<min){
                min = arr[i];
                index = i;
            }
        } return index;
    }

    public static void main(String[] args) {
        int[] array ={4,2,4,5,6,2,9,1,2,4};
        int index1  = timMinMang(array);
        System.out.println("Vị trí phần tử có giá trị nhỏ nhất là "+index1);
    }
}
