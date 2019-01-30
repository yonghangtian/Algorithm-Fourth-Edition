package sort_algos;

/**
 * @author tianyh
 * this progrma can find the sub array with biggest sum from a int array.
 */
public class MaxSubArray {

    public static void main(String[] args) {
        int[] nums = {-3,-2,-1,-5,-7};
        MaxSubArray m = new MaxSubArray();
        System.out.println(m.findGreatestSumOfSubArray(nums));
    }

    public int findGreatestSumOfSubArray(int[] array) {
        if(array.length == 0){
            return 0;
        }
        if (array.length < 2){
            return array[0];
        }
        int start = 0;
        int end = array.length - 1;

        return maxSum(array,start,end);
    }

    private int maxSum(int[] array, int start, int end){
        if (start == end){
            return array[start];
        }
        int mid = (start + end)/2;
        // calculate the left hand side
        int left = maxSum(array, start, mid);

        // calculate the left hand side
        int right = maxSum(array, mid+1, end);

        // calculate cross bounder left side
        int maxL = array[start];
        int temp = 0;

        for(int i = mid; i >= start; i--){
            temp += array[i];
            if (temp > maxL){
                maxL = temp;
            }
        }
        // calculate cross bounder right side
        temp = 0;
        int maxR = array[end];
        for (int i = mid+1; i <= end; i++){
            temp += array[i];
            if (temp > maxR){
                maxR = temp;
            }
        }
        int cross = maxL + maxR;

        return this.bigger(left,cross,right);
    }

    private int bigger(int a, int b, int c){
        if(a >= b && a >= c){
            return a;
        }else if(b >= a && b >= c){
            return b;
        }else{
            return c;
        }
    }
}