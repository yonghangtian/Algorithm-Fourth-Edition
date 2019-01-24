import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SmallestInteger {
    public String samllestInteger(int[] nums){
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0, len = nums.length; i < len; i++) {
            list.add(nums[i]);
        }
        //实现了Comparator接口的compare方法，将集合元素按照compare方法的规则进行排序
        // 这种写法应该叫匿名类？ 重新看一下JAVA基础！！！
        Collections.sort(list, new Comparator<Integer>() {

            // compare rules:
            // if ab > ba then, a > b
            @Override
            public int compare(Integer o1, Integer o2) {
                String s1 = ""+o1+o2;
                String s2 = ""+o2+o1;

                return s1.compareTo(s2);
            }
        });

        String s = "";
        for (Integer num : list){
            s = s + num;
        }
        return s;
    }

    public static void main(String[] args) {
        SmallestInteger s = new SmallestInteger();
        int[] nums = {1,2,3};
        System.out.println(s.samllestInteger(nums));
    }
}
