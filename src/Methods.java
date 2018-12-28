public class Methods {
    int[] histogram(int[] a, int M){
        int l = a.length;
        int[] b = new int[M];
        for (int i = 0; i < M; i ++) {
            int k = 0;
            for (int j = 0; j < l; j ++){
                if(a[j] == i){
                    k += 1;
                }
            }
            b[i] = k;
        }
        return b;
    }
}
