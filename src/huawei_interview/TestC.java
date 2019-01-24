package huawei_interview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TestC {
    public static void main(String[] args) {
        int[][] inputM = {{1,2,3},{2,3,1},{4,5,6}};
        Map<String,Integer> seqAndScore = new HashMap<>();
        int k = 1;
        calculateScore(seqAndScore, inputM, k);
        for (String seq: seqAndScore.keySet()){
            System.out.println("the seq is "+ seq +", and its score is "+seqAndScore.get(seq));
        }
    }

    private static void calculateScore(Map<String, Integer> seqAndScore, int[][] inputM, int k) {

        ArrayList<HashMap> info = new ArrayList<>();
        for (int i = 0; i < inputM.length; i++){
            HashMap<Integer, Integer> indexAndScore = new HashMap<>();
            for (int j = 0; j < inputM[i].length; j++){
                indexAndScore.put(j,inputM[i][j]);
            }
            info.add(indexAndScore);
        }
//        initial sequence
        String seq = "";
//        initial score of a sequence
        int score = 1;
//        initial the largest score in a certain row.
        int large = 0;
//        repaat K times, since we need to find the largest K sequences
        for (int j = 0; j < k ; j++) {
            large = 0;
            for(HashMap index : info){
                for (Object i : index.keySet()){
//                    find the index of largest score in this row.
                    if((Integer)index.get(i) > large){
                        large = (Integer)i ;
                    }
                }
//                add the index of the largest score in this row
                seq = seq + large;
//                calculate the score
                score = score *(Integer)index.get(large);
            }
            info.get(j).remove(large);
//            store them in hashmap.
            seqAndScore.put(seq,score);
        }
    }
}
