import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {
    public class Pair{
        int i;
        int j;
        int time;
        public Pair(int a,int b,int t){
            i=a;
            j=b;
            time=t;
        }
    }

    int[] X={-1,1,0,0};
    int[] Y={0,0,-1,1};
    int row;
    int col;
    public int orangesRotting(int[][] grid) {
        int max = -1;
        row = grid.length;
        col = grid[0].length;
        Queue<Pair> rotten = new LinkedList<>();
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]==2){
                    rotten.add(new Pair(i,j,0));
                }
            }
        }

        if(rotten.isEmpty())max=0;

        while(!rotten.isEmpty()){
            Pair pair = rotten.remove();

            for(int k=0;k<4;k++){
                int x=pair.i+X[k];
                int y=pair.j+Y[k];
                max = Math.max(max,pair.time);
                if(x>=0 && y>=0 && x<row && y<col){
                    if(grid[x][y]==1){
                        grid[x][y]=-1;
                        rotten.add(new Pair(x,y,pair.time+1));
                    }
                }
            }
        }

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]==1) return -1;
            }
        }

        return max;
    }
    public static void main(String[] args) {
//        int[][] grid = {{2, 1, 1},{1, 1, 0},{0, 1, 1}};
//        int[][] grid = {{2, 1, 1}, {0, 1, 1}, {1, 0, 1}};
//        int[][] grid = {{0, 2}};
//        int[][] grid = {{0}};
//        int[][] grid = {{1}};
        int[][] grid = {{1}, {2}};
        System.out.println(new RottingOranges().orangesRotting(grid));
    }
}
