

public class RobotRoad {
    public static void main(String[] args) {
        int threshold = 15;
        int rows = 20;
        int cols = 20;
        RobotRoad r = new RobotRoad();
        System.out.println(r.movingCount(threshold,rows,cols));
    }
    public int movingCount(int threshold, int rows, int cols)
    {
        if(threshold < 0 || rows <= 0 || cols <= 0){
            return 0;
        }
        int count = 0;
        int row = 0;
        int col = 0;
        boolean[][] visited = new boolean[rows][cols];
        count = countSteps(threshold, rows, cols, row, col, visited);
        return count;
    }
    private int countSteps(int threshold, int rows, int cols, int row, int col, boolean[][] visited){
        // remember that row can not bigger than rows - 1, since row is in [0,rows-1]
        // and col is in [0,cols-1]
        if(row < 0||col < 0||row > rows-1 || col > cols-1 || calDigitSum(row,col) > threshold
                || visited[row][col]){
            return 0;
        }
        int count = 0;
        visited[row][col] = true;
        count = 1 + countSteps(threshold,rows,cols,row,col-1,visited)+
                countSteps(threshold,rows,cols,row,col+1,visited)+
                countSteps(threshold,rows,cols,row-1,col,visited)+
                countSteps(threshold,rows,cols,row+1,col,visited);
        return count;

    }
    private int calDigitSum(int x, int y){
        int sum = 0;
        while (x > 0){
            sum += x%10;
            x = x/10;
        }
        while (y > 0){
            sum += y%10;
            y = y/10;
        }

        return sum;
    }
}