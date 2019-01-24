import java.util.ArrayList;

public class PrintMatrixClockWise {
    public static void main(String[] args) {
        int[][] m = {{1,2},{3,4}};
        PrintMatrixClockWise p = new PrintMatrixClockWise();
        ArrayList<Integer> a = p.printMatrix(m);

    }
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> nums = new ArrayList<>();
        int endrow = matrix.length-1;
        int endcol = matrix[0].length-1;
        printMatrixClockWise(matrix,0,0,endrow,endcol,nums);
        return nums;
    }
    // br is begin row, bc is begin column, er is endrow, ec is endcolumn.
    public void printMatrixClockWise(int[][] m, int br,int bc, int er, int ec, ArrayList<Integer> nums){
        if((br < er)&&(bc < ec)){
            //right
            for(int i = bc; i <= ec; i++){
                nums.add(m[br][i]);
            }
            //down
            for(int j = br + 1; j <= er - 1; j++){
                nums.add(m[j][ec]);
            }
            //left
            for(int i = ec; i >= bc; i--){
                nums.add(m[er][i]);
            }
            //up
            for(int j = er - 1; j >= br+1; j--){
                nums.add(m[j][bc]);
            }
            printMatrixClockWise(m,br+1,bc+1,er-1,ec-1,nums);
        }
        else if((br == er)&&(bc < ec)){
            for(int i = bc; i <= ec; i++){
                nums.add(m[er][i]);
            }
        }
        else if((br < er)&&(bc == ec)){
            for(int j = br; j <= er; j++){
                nums.add(m[j][ec]);
            }
        }
        else if((br == er)&&(bc == ec)){
            nums.add(m[er][ec]);
        }
        else{
            return ;
        }

    }
}