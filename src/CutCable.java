

public class CutCable {
    public static void main(String[] args) {
        int length = 5;
        int result = maxValueCutCable(length);
        System.out.println(result);
    }

    private static int maxValueCutCable(int len) {
        // when len = 1, since we need to make at least one cut, so result is 0.
        if (len < 2){
            return 0;
        }
        if (len == 2){
            return 1;
        }
        if (len == 3){
            return 2;
        }
        // important : 注意result中的值指的是剪到那个值时最大的乘积（可能不会再剪下去，于是最大就是它本身）
        // 而上面直接返回的是总长度就是那么多时的情况。
        // create a array length is len+1, then we can use index to represent parameter: len
        int[] result = new int[len+1];
        result[0] = 0;
        result[1] = 1;
        result[2] = 2;
        result[3] = 3;

        for (int i = 4; i <= len; i ++){
            int max = 0;
            for (int j = 1; j <= i/2 + 1; j++) {
                int curMax = result[j] * result[i-j];
                if (curMax > max){
                    max = curMax;
                }
            }
            result[i] = max;
        }
        return result[len];
    }
}
