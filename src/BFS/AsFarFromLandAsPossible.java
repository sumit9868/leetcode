package BFS;

import java.util.*;

/**
 * leet code question
 * 1162. As Far form Land as Possible
 * */
public class AsFarFromLandAsPossible {
    private class Pair{
        int x;
        int y;
        int d;
        public Pair(int i, int j, int k){
            x=i;
            y=j;
            d=k;
        }
    }
    int[] X={-1,1,0,0};
    int[] Y={0,0,-1,1};
    public int maxDistance(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        Queue<Pair> queue = new LinkedList<>();
        for(int i=0;i<row;i++){
            for (int j = 0; j < col; j++) {
                if(grid[i][j]==1){
                    grid[i][j] = -1;
                    queue.add(new Pair(i,j,0));
                }
            }
        }
//        visited = new HashSet<>();
        int max = -1;
        while (!queue.isEmpty()){
            Pair pair = queue.remove();
            int i= pair.x;
            int j= pair.y;
            max = Math.max(max, pair.d);
            for(int k=0;k<4;k++){
                int x = X[k]+i;
                int y = Y[k]+j;
                if(x>=0 && y>=0 && x<row && y<col && grid[x][y]==0){
                    grid[x][y]=-1;
                    queue.add(new Pair(x,y, pair.d+1));
                }
            }

        }
        return max;
    }

    public static void main(String[] args) {
//        int [][] grid = {{1, 0, 1}, {0, 0, 0}, {1, 0, 1}};
        int [][] grid = {
                {0, 0, 1, 1, 1},
                {0, 1, 1, 0, 0},
                {0, 0, 1, 1, 0},
                {1, 0, 0, 0, 0},
                {1, 1, 0, 0, 1}};
        System.out.println(new AsFarFromLandAsPossible().maxDistance(grid));
        for(int[] row: grid){
            System.out.println(Arrays.toString(row));
        }
    }
}
