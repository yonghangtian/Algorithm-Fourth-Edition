public class InversePairs {
    public int inversePairs(int[] nums){
        if(nums.length < 1 && nums == null){
            return -1;
        }
        int[] sorted = new int[nums.length];

        return inversePairsCore(sorted,nums,0,nums.length-1);

    }

    private int inversePairsCore(int[] sorted, int[] nums, int start, int end) {
        if (start == end){
            sorted[start] = nums[start];
            return 0;
        }

        int len = (end - start)/2;

        int left = inversePairsCore(sorted,nums,start,start+len);
        int right = inversePairsCore(sorted,nums,start+len+1,end);

        int sortIndex = end;
//      count inverse pairs
        int count = 0;
//        pointer for left side
        int i = start+len;
//        pointer for right side
        int j = end;
        while ((i >= start) && (j >= start+len+1)){
            if (nums[i] > nums[j]) {
                sorted[sortIndex] = nums[i];
                i--;
                sortIndex--;
                // add all num small than nums[j] in the right hand side.
                count += j-(start+len+1)+1;
            }else {
                sorted[sortIndex] = nums[j];
                j--;
                sortIndex--;
            }
        }

        while (i >= start){
            sorted[sortIndex] = nums[i];
            i--;
            sortIndex--;
        }
        while (j >= start+len+1){
            sorted[sortIndex] = nums[j];
            j--;
            sortIndex--;
        }

        return count+left+right;
    }

    public static void main(String[] args) {
//    System.out.println(true&&false||false);
        InversePairs i = new InversePairs();
        int[] data = {1, 2, 3, 4, 7, 6, 5};
        System.out.println(i.inversePairs(data)); // 3
        int[] data2 = {6, 5, 4, 3, 2, 1};
        System.out.println(i.inversePairs(data2)); //  15
        int[] data3 = {1, 2, 3, 4, 5, 6};
        System.out.println(i.inversePairs(data3)); // 0
        int[] data4 = {1};
        System.out.println(i.inversePairs(data4)); // 0
        int[] data5 = {1, 2};
        System.out.println(i.inversePairs(data5)); // 0
        int[] data6 = {2, 1};
        System.out.println(i.inversePairs(data6)); // 1
        int[] data7 = {1, 2, 1, 2, 1};
        System.out.println(i.inversePairs(data7)); // 3
    }

}

