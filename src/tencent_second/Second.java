package tencent_second;

import java.util.Scanner;
public class Second {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // the length
        int n = sc.nextInt();
        String str = sc.next();
        String type1 = "01";
        String type2 = "10";
        if (n < 2){
            System.out.println(n);
        }
        while (str.contains(type1)||str.contains(type2)){
            str = rmCertainType(str,type1);
            str = rmCertainType(str,type2);
        }
        char[] chars = str.toCharArray();
        System.out.println(chars.length);
    }
    private static String rmCertainType(String str, String type){
        if (str.contains(type)){
            while (str.contains(type)){
                StringBuffer sb = new StringBuffer();
                String[] strArr = str.split(type);
                for (int i = 0; i < strArr.length; i++) {
                    if (!strArr[i].equals(type)){
                        sb.append(strArr[i]);
                    }
                }
                str = sb.toString();
            }
        }
        return str;
    }
}
