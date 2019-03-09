import java.util.Arrays;

public class ReOrderArray {

    public static void main(String[] args) {
        ReOrderArray r = new ReOrderArray();
        int[] arr = {1,2,3,4,5,6,7};
        r.reOrderArray(arr);
        System.out.println(Arrays.toString(arr));
    }

    public void reOrderArray(int[] arr) {
        int begin = 0;
        int end = arr.length-1;
        while (begin < end){
            while ( (begin < end) && (!isEven(arr[begin])) ){
                begin++;
            }
            while ( (begin < end) && (isEven(arr[end])) ){
                end--;
            }
            if (begin < end){
                int temp = arr[begin];
                arr[begin] = arr[end];
                arr[end] = temp;
            }
        }
    }

    private boolean isEven(int num){
        return num % 2 == 0;
    }
}
