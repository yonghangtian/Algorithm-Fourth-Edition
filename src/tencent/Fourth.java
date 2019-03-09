package tencent;

import java.util.HashMap;
import java.util.Scanner;

public class Fourth {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // n <= 1000000(1e6)
        int n = sc.nextInt();
        // m <= 2000
        int m = sc.nextInt();

        if (n < m || n <= 0 || m <= 0 || m > 2000 || n > 1000000){
            return ;
        }
        // store data
        int[] result = new int[n];
        for (int i = 0; i < n; i ++){
            result[i] = sc.nextInt();
        }

        int num;
        int freq;
        HashMap<Integer,Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++){
            num = result[i];

            if (!map.containsKey(num)){
                map.put(num,1);
            }else{
                freq = map.get(num)+1;
                map.put(num,freq);
            }

            if (map.size() == m){
                System.out.println(getTotal(map, m, i, result));
                break;
            }
        }

        if (map.size() < m){
            System.out.println("-1");
        }
    }
    private static int getTotal(HashMap<Integer,Integer> map, int m,int i, int[] result){

        int start = 0;
        int num;

        while(map.size() == m){
            num = result[start];
            int freq = map.get(num);
            if (freq > 1){
                map.put(num,freq-1);
                start++;
            }else{
                break;
            }
        }

        return (i - start + 1);
    }
}
