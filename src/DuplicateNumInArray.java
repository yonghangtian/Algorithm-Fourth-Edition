
import java.util.ArrayList;
public class DuplicateNumInArray {
    // Parameters:
    //    numbers:     an array of integers
    //    length:      the length of array numbers
    //    duplication: (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
    //                  Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
    //    这里要特别注意~返回任意重复的一个，赋值duplication[0]
    // Return value:       true if the input is valid, and there are some duplications in the array number
    //                     otherwise false
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < length; i++){
            if(numbers[i] == i){
                continue;
            }else if (numbers[i] != i){
                if (numbers[numbers[i]] == numbers[i]){
                    list.add(numbers[i]);
                }else{
                    int temp = numbers[i];
                    numbers[i] = numbers[temp];
                    numbers[temp] = temp;
                }
            }
        }
        if (list.size() != 0){
            duplication[0] = list.get(0);
            return true;
        }
        duplication[0] = -1;
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {2,1,3,0,4};
        int[] dup = new int[1];
        DuplicateNumInArray d = new DuplicateNumInArray();

        System.out.println(d.duplicate(nums,nums.length,dup));
        System.out.println(dup[0]);
    }
}