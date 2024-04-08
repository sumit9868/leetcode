import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {
    int []X ={-1,1,0,0};
    int []Y ={0,0,1,-1};
    int row;
    int col;
    public static class Pair<I,J>{
        public I i;
        public J j;
        public Pair(I t, J h){
            i=t;
            j=h;
        }
    }

    public int numIslands(char[][] grid) {
        count =0;
        row = grid.length;
        col = grid[0].length;
        int[][] island = new int[row][col];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]=='1'){
                    BFS(grid,i,j);
                    count++;
                }
            }
        }

        return count;
    }

    private void BFS(char[][] grid, int i, int j) {
        Queue<Pair<Integer,Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(i,j));
        while(!queue.isEmpty()){
            Pair<Integer,Integer> pair = queue.remove();
            for(int k=0;k<4;k++){
                int x,y;
                x=X[k]+pair.i;
                y=Y[k]+pair.j;

                if(x>=0 && y>=0 && x<row && y<col && grid[x][y]=='1'){
                    grid[x][y]='0';
                    queue.add(new Pair<>(x,y));
                }
            }
        }
    }


    int count;
    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}};

        System.out.println(new NumberOfIslands().numIslands(grid));
    }
}