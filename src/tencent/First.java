package tencent;

import java.util.Scanner;

public class First {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 最大面额
        int n = sc.nextInt();
        // 商品价格
        long m = sc.nextLong();

        if ( n <= 0 || m <= 0L){
            return ;
        }

        System.out.println(smallestNum(n,m));


    }
    private static long smallestNum(int n, long m){
        if (m <= n){
            return 1L;
        }
        long times = m/n;
        m = m%n;
        return times+smallestNum(n,m);
    }
}
