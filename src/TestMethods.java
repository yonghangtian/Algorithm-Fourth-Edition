public class TestMethods {
    public static void main( String[] args) {
        int[] a = {1,2, 3, 4, 5, 6, 7, 8};
        int M = 10;
        int[] b = new int[M];
        Methods c = new Methods();
        b = c.histogram(a,M);
        for (int i = 0; i < M; i ++) {
            System.out.println(b[i]);
        }

        /*int[] a = new int[10];
        for (int i = 0; i < 10; i++)
            a[i] = 9 - i;
        for (int i = 0; i < 10; i++)
            a[i] = a[a[i]];
        for (int i = 0; i < 10; i++)
            System.out.println(i);*/
        /*String m = "cols:";
        StdOut.printf("%7s",m);
        for(int k = 1; k <= 6; k++){
            StdOut.printf("%2d",k);
        }
        StdOut.println();
        for (int i = 0; i < 6; i++) {
            StdOut.print("row "+i+": ");
            for (int j = 0; j < 6; j++) {
                StdOut.print(" "+ (j%2));
                if(j == 5){
                    StdOut.println();
                }
            }
        }*/
        /*System.out.println('C'+'b');
        System.out.println((char) ('C'+ 4));
        String s ="";
        int N = StdIn.readInt();
        for(int n = N; n > 0; n /= 2){
            s = (n%2) + s;
        }
        System.out.println(s);*/

        /*int f = 0;
        int g = 1;
        int i = 0;
        while( i <= 15){
            StdOut.println(f);
            f = f + g;
            g = f - g;
            i += 1;
        }*/
    }
        /*double[] nubs = new double[3];
        int i = 0;
        while (!StdIn.isEmpty()){
            nubs[i] = StdIn.readDouble();
            i+=1;
        }
        if ((nubs[0]>=0.0)&&(nubs[0]<=1.0)){
            if((nubs[1]>=0.0)&&(nubs[1]<=1.0)){
                StdOut.print("true");
            }
            else StdOut.print("false");
        }
        else StdOut.print("false");*/

/*        if((nubs[0]==nubs[1])){
            if (nubs[1]==nubs[2]) {
                StdOut.print("equal");
            }
            else StdOut.print("not equal");
        }
        else StdOut.print("not equal");
    }*/
}
