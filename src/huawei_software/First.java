package huawei_software;

import java.util.LinkedList;
import java.util.Scanner;
public class First {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        LinkedList<Character> queue = new LinkedList<>();

        int result = 0;
        char[] charArr = input.toCharArray();

        for (int i = 0; i < charArr.length; i++) {
            queue.addLast(charArr[i]);
        }
        LinkedList<Character> operators = new LinkedList<>();
        LinkedList<Integer> nums = new LinkedList<>();

        String str = "";
        int num = 0;
        while (!queue.isEmpty()) {
            char chr = queue.poll();
            if (chr != '+' && chr != '-') {
                str += chr;
                continue;
            }
            operators.addLast(chr);
            nums.addLast(Integer.parseInt(str));
            str = "";
        }

        if (str != ""){
            nums.addLast(Integer.parseInt(str));
        }

        result = nums.poll();
        while (!operators.isEmpty()){
            num = nums.poll();
            if(operators.poll() == '+'){
                result += num;
            }else{
                result -= num;
            }
        }

        System.out.println(result);
    }
}
