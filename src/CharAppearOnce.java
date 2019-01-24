
import java.util.ArrayList;

public class CharAppearOnce {
    public int FirstNotRepeatingChar(String str) {
        if(str==null){
            return -1;
        }
        ArrayList<Character> used = new ArrayList<>();
        ArrayList<Character> list = new ArrayList<>();
        for (int i = 0; i < str.length(); i++){
            char chr = str.charAt(i);

            if(!list.contains(chr)&&!used.contains(chr)){
                list.add((Character) chr);
            }else{
                used.add((Character) chr);
                list.remove((Character) chr);
            }
        }

        if (list.size() <= 0){
            return -1;

        }
        return str.indexOf(list.get(0));
    }

    public static void main(String[] args) {
        CharAppearOnce c = new CharAppearOnce();
        String str = "googgle";
        System.out.println(c.FirstNotRepeatingChar(str));
    }
}