package huawei_interview;

public class TestB {
    public static void main(String[] args) {
        int[] array = new int[]{7,11,13,0,2,3,5};
        int target = 3;
//        int index = searchArray(target, array);
        int count = 0;
        int index = divideSearch(target,array,count);
        if(index != -1){
            System.out.println("the index of target "+target+" is "+index);
            //System.out.println(count);
        }
        else{
            System.out.println("cannot find target in this array");
        }
    }

    private static int searchArray(int target, int[] array) {
        for(int i = 0; i < array.length; i++){
            if(target == array[i]){
                return i;
            }
        }
        return -1;
    }

    //another way is to find the middle of that array, where array[i] > array[i+1]
    private static int divideSearch(int target, int[] array,int count){
        if(target >= array[0]){
            return searchArray(target,array);
        }
        else if (target <= array[array.length-1]){
            for (int j = array.length-1; j>=0; j-- ){
                count += 1;
                if (target == array[j]){
                    System.out.println(count);
                    return j;
                }
            }
            return -1;
        }
        else{
            return -1;
        }
    }
}