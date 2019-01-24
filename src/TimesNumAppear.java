
public class TimesNumAppear {

    public int getNumberOfK(int[] array, int k) {

        int count = 0;
        int start = 0;
        int end = array.length-1;
        int index = binarySearch(array, start, end, k);
//        if the index is -1, it means that k is not in array.
        if(index == -1){
            return 0;
        }


        for (int i = index; i < array.length; i++){
            if(array[i] == k){
                count += 1;
            }
        }
        return count;
    }

    /**
     *
     * @param arr
     * @param start
     * @param end
     * @param k
     * @return
     */
    private int binarySearch(int[] arr, int start, int end, int k){
        if (start > end){
            return -1;
        }

        int middleIdx = (start + end)/2;
        int middleData = arr[middleIdx];
        if (middleData == k){
            if (middleIdx > 0 && arr[middleIdx -1] != k || middleIdx == 0){
                return middleIdx;
            }else{
                end = middleIdx - 1;
            }
        }else if (middleData > k){
            end = middleIdx - 1;
        }else{
            start = middleIdx + 1;
        }
        return binarySearch(arr,start,end,k);
    }

    //main
    public static void main(String[] args) {
        TimesNumAppear t = new TimesNumAppear();
        System.out.println(t.getNumberOfK(new int[]{1, 3, 3, 3, 3, 3, 4, 5},3));
    }
}
