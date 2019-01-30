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
        int i = start, j= end + 1;
        int pivot = nums[start];
        while (true){
            while (nums[++i] <= pivot){
                if (i == end){
                    break;
                }
            }

            while (nums[--j] >= pivot){
                if (j == start){
                    break;
                }
            }

            if (i >= j){
                break;
            }

            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

        nums[start] = nums[j];
        nums[j] = pivot;

        return j;
    }
}
