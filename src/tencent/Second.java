package tencent;

import java.util.Scanner;

public class Second {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int q  = sc.nextInt();
        if (q == 0){
            return ;
        }
        Long[][] arr = new Long[q][2];
        for (int i = 0; i < q; i++){
            for(int j = 0; j < 2; j++){
                arr[i][j] = sc.nextLong();
            }
        }
        long start, end;
        for (int i = 0; i < q; i++){
            start = arr[i][0];
            end = arr[i][1];
            if (start > end || start < 1L || end < 1L){
                return ;
            }
            System.out.println(sumOfArr(start,end));
        }


    }
    private static long sumOfArr(long start, long end){
        if (start%2 == 1 && end%2 == 1){
            return (end - start)/2-end;
        }
        if (start%2 == 0 && end%2 == 0){
            return end - (end - start)/2;
        }

        if (start%2 == 1 && end%2 == 0){
            return (end - start - 1)/2 + 1;

        }
        if (start%2 == 0 && end%2 == 1){
            return -1 - (end - start -1)/2;
        }
        return 0;
    }
}
