
/**
 * @author tianyh
 * this algothrim is almost the same with DuplicateNumInArray.java,
 * However, this algorithm can not guarantee to find all duplicate nums.
 *
 * 题目： 在一个n+1的数组中，所有数都在[1,n] 范围内，所以肯定有一个数重复，请找出。
 * 条件： 不改变数组。
 */
public class DuplicateNumInArray2 {
    public static void main(String[] args) {
        int[] nums = {};
        int[] dup = new int[1];
        DuplicateNumInArray2 d = new DuplicateNumInArray2();
        d.findDuplicate(nums,dup);
        System.out.println(dup[0]);
    }

    private void findDuplicate(int[] nums, int[] dup) {
        if (nums.length == 0||nums.length < 2){
            System.out.println("invalid input: input lenth too short.");
        }
        int len = nums.length;

        int start = 1;
        int end = len-1;
        while (start <= end){
            int middle = (end - start)/2 + start;
            int count = countRange(nums, start, middle, len);
//            we cannot move this part out of circle, since we need count to do decision.
            if (end == start){
                if (count > 1){
                    dup[0] = start;
                    break;
                }
                else{
                    dup[0] = -1;
                    break;
                }
            }else if (count > middle - start + 1){
                end = middle;
            }else{
                start = middle + 1;
            }
        }
    }

    private int countRange(int[] nums, int start, int middle, int len) {
        int count = 0;
        for (int i = 0; i < len; i++){
            if (nums[i] >= start && nums[i] <= middle){
                count++;
            }
        }
        return count;
    }
}
