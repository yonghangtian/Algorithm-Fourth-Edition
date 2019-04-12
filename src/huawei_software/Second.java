package huawei_software;

import java.util.*;

public class Second {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        char[] arr = input.toCharArray();

        Set<Character> all = new LinkedHashSet<>();

        TreeSet<Character> low = new TreeSet<>();
        TreeSet<Character> high = new TreeSet<>();

        for (int i = 0; i < arr.length; i ++){
            if(arr[i] >=65 && arr[i] <=90){
                high.add(arr[i]);
            }
            all.add(arr[i]);
        }

        // 用low来表示包含的大小写字母对。
        for (char chr : high){
            if (all.contains(chr+32)) {
                low.add((char) (chr + 32));
            }
        }

        while(!low.isEmpty()){
            printLongest(low);
            updateLow(low, all);
        }

    }

    private static void updateLow(TreeSet<Character> low, Set<Character> all) {
        int first = 0;
        for (char chr : all){
            if (low.contains(chr) || low.contains((char)(chr-32)) && first == 0){
                first = 1;
                low.remove(chr);
            }
        }
    }

    private static void printLongest(TreeSet<Character> low){
        int max = 0;
        int length = 0;
        for (char start : low){
            while (low.contains((char) (start + 1)))
            {
                length += 1;
            }
            if (length > max){
                max = length;
            }
        }
    }
}
