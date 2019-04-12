package tencent_second;

import java.util.Scanner;

public class Third {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] powers = new long[n];
        long[] moneys = new long[n];

        for (int i = 0; i < n; i++) {
            powers[i] = sc.nextLong();
        }

        for (int i = 0; i < n; i++) {
            moneys[i] = sc.nextLong();
        }

        long currPower = 0;
        long totalMoney = 0;

        for (int i = 0; i < n; i++) {
            if (currPower < powers[i]){
                if ((totalMoney+moneys[i]) > sum(moneys,0,i-1) &&powers[i] < sum(powers,0,i-1)){
                    totalMoney = sum(moneys,0,i-1);
                    currPower = sum(powers,0,i-1);
                    continue;
                }
                totalMoney += moneys[i];
                currPower += powers[i];
            }else{
                continue;
            }
        }

        System.out.println(totalMoney);
    }
    private static long sum(long[] arr, int start, int end){
        long sum = 0;
        for (int i = start; i <= end; i++){
            sum += arr[i];
        }
        return sum;
    }
}
