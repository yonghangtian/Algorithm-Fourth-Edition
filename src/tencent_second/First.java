package tencent_second;

import java.util.Scanner;
import java.util.TreeSet;

public class First {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 面值
        int m = sc.nextInt();
        // 硬币种类数量
        int n = sc.nextInt();

        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            set.add(sc.nextInt());
        }

        System.out.println(findSmallestTypes(set,m,n));
    }
    private static int findSmallestTypes(TreeSet<Integer> set, int m, int n){
        int type = 0;
        if (!set.contains(1)){
            return -1;
        }
        for (int i = 1; i <= m; i++) {

        }

        return -1;
    }
}

