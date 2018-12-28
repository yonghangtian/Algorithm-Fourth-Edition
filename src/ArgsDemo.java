import com.sun.istack.internal.NotNull;

public class ArgsDemo {// can only run in commandline. not in ide
    public static void main(@NotNull String[] args) {
        String str = new String();
        for (int i = 0; i < args.length; i++) {
            System.out.println(args[i]);
            str += args[i];
        }
        System.out.println(str);
    }
}
