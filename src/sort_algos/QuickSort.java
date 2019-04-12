package sort_algos;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] nums = {2,5,1,8,4,7,3};
        quickSort(nums,0,nums.length-1);
        System.out.println(Arrays.toString(nums));
    }

    private static void quickSort(int[] nums, int start, int end) {
        if(start < end){
            int mid = partition(nums,start,end);
            quickSort(nums,start,mid);
            quickSort(nums,mid+1,end);
        }
    }

    private static int getMid(int[] nums, int start, int end) {
        if (end == start){
            return  start;
        }
        int pivot = nums[start];
        while (start < end ){
            while (nums[end] >= pivot && start < end ) {
                end--;
            }
            nums[start] = nums[end];

            while (nums[start] <= pivot && start < end){
                start++;
            }
            nums[end] = nums[start];
        }
        nums[start] = pivot;

        return start;
    }

    private static int partition(int[] nums, int start, int end){
        int pivot = nums[start];
        int i = start;
        int j = end;
        while (i < j){

            while (i < j && pivot <= nums[j]){
                j --;
            }
            // 因为这里的条件是pivot >= nums[i], 所以 nums[start] 没有移动，一直就是pivot
            while (i < j && pivot >= nums[i]){
                i ++;
            }

            if (i < j){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }

        }

        nums[start] = nums[i];
        nums[i] = pivot;
        return i;
    }
}
