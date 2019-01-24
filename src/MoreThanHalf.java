import java.util.HashMap;
public class MoreThanHalf {
    public int morethanhalfnumSolution(int [] array) {
        int len = array.length;
        HashMap<Integer, Integer> wordCount = new HashMap<>();
        for (int i = 0; i < len; i++){
            if(wordCount.get(array[i]) == null){
                wordCount.put(array[i],1);
            }else{
                int num = wordCount.get(array[i]);
                wordCount.replace(array[i],num+1);
            }
        }
        int returnKey = 0;
        for (Integer key : wordCount.keySet()){
            if(wordCount.get(key) > (len/2)){
                returnKey = key;
            }
        }
        return returnKey;
    }

    public static void main(String[] args) {
        MoreThanHalf m = new MoreThanHalf();
        int[] array = {1,2,2};
        int key = m.morethanhalfnumSolution(array);
        System.out.println(key);
    }
}