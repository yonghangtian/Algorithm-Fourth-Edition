package tencent;

import java.util.Scanner;

public class Third {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int s = sc.nextInt();
        if (n <= 0 || s < 0){
            return ;
        }
        int[] result = new int[n];
        for (int i = 0; i < n; i++){
            if (sc.nextInt() > 2 || sc.nextInt() < 0){
                return ;
            }
            result[i] = sc.nextInt();
        }


    }
}
