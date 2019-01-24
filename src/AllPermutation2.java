import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 剑指中：字符串全排问题（包含重复字符）

public class AllPermutation2 {
    List<String> res = new ArrayList<>();

    public List<String> Permutation(String str) {
        char[] chrs = str.toCharArray();
        int len = chrs.length;
        if(len==0||chrs==null) {
            return res;
        }
//        after initial, used[i] are all false.
        boolean[] used = new boolean[len];
        List<Character> list = new ArrayList<>();

        Arrays.sort(chrs);
        dfs(chrs, used, list, len);

        return res;
    }

    public void dfs(char[] chrs, boolean[] used, List<Character> list, int len) {
        if(list.size()==len) {
            String str = "";
            for (Character chr : list){
                str = str + (char) chr;
            }
            res.add(str);
            return ;
        }
        for (int i=0; i<len; i++) {
            // 当前位置的数已经在List中了
            if(used[i]) {
                continue;
            }
            // 当前元素与其前一个元素值相同 且 前元素未被加到list中，跳过该元素
            if(i>0 && chrs[i]==chrs[i-1] && !used[i-1]) {
                continue;
            }
            // 深度优先搜索遍历
            used[i] = true;
            list.add(chrs[i]);
            dfs(chrs, used, list, len);
            list.remove(list.size()-1);
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        String str = "1123";
        AllPermutation2 p = new AllPermutation2();
        List<String> res = p.Permutation(str);
        System.out.println("1");
    }

}
