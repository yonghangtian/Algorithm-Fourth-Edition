import java.util.Scanner;
public class HDEChallenge3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        process(num,sc);
    }
    private static void process(int num,Scanner sc){
        if(num == 0){
            return;
        }
        int items = sc.nextInt();
        int sum = 0;
        sum = calSum(items, sum, sc);
        System.out.println(sum);
        process(num-1, sc);
    }
    private static int calSum(int items, int sum,Scanner sc){
        if(items == 0){
            return sum;
        }
        int item = sc.nextInt();
        if(item > 0){
            // it's wrong to use "sum += item^2; ". '^' is 'bitwis XOR(异或)'
            sum += (int) Math.pow((double) item, 2);
        }
        return calSum(items-1,sum, sc);
    }
}
