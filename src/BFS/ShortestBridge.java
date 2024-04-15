package BFS;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * leet code question
 * 934. Shortest Bridge
 * */
public class ShortestBridge {

    private class Pair implements Comparable<Pair>{
        int i;
        int j;
        int d;

        public Pair(int x, int y, int z) {
            i = x;
            j = y;
            d = z;
        }

        @Override
        public int compareTo(Pair o) {
            return this.d-o.d;
        }
    }

    int[] X = {-1, 1, 0, 0};
    int[] Y = {0, 0, -1, 1};
    int row;
    int col;
    public int shortestBridge(int[][] grid) {
        row = grid.length;
        col = grid[0].length;

        Queue<Pair> queue = new LinkedList<>();
        boolean flag = false;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    BFS(grid,i,j);
                    flag=true;
                    break;
                }
            }
            if(flag) break;
        }


        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == -1) {
                    queue.add(new Pair(i, j, 0));
                }
            }
        }

        int min = Integer.MAX_VALUE;
        while (!queue.isEmpty()) {
            Pair pair = queue.remove();
            grid[pair.i][pair.j]=-1;
            for (int k = 0; k < 4; k++) {
                int x = pair.i + X[k];
                int y = pair.j + Y[k];
                if (x >= 0 && y >= 0 && x < row && y < col) {
                    if (grid[x][y] == 0) queue.add(new Pair(x, y, pair.d + 1));
                    if (grid[x][y] == 1) min = Math.min(min,pair.d);
                }
            }
        }
        return min;
    }

    private void BFS(int[][] grid, int i, int j) {
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(i,j,0));
        while(!queue.isEmpty()){
            Pair pair = queue.remove();
            grid[pair.i][pair.j] = -1;
            for(int k=0;k<4;k++){
                int x = pair.i+X[k];
                int y = pair.j+Y[k];
                if(x >= 0 && y >= 0 && x < row && y < col && grid[x][y]==1){
                    queue.add(new Pair(x,y,0));
                }
            }
        }
    }

    public static void main(String[] args) {
//        int[][] grid = {{0, 1}, {1, 0}};
//        int[][] grid = {{0, 1, 0}, {0, 0, 0}, {0, 0, 1}};
        int[][] grid = {
                {1, 1, 1, 1, 1},
                {1, 0, 0, 0, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 0, 0, 1},
                {1, 1, 1, 1, 1}};

//        int[][] grid = {
//                {0, 0, 1, 0, 1},
//                {0, 1, 1, 0, 1},
//                {0, 1, 0, 0, 1},
//                {0, 0, 0, 0, 0},
//                {0, 0, 0, 0, 0}
//        };

        System.out.println(new ShortestBridge().shortestBridge(grid));
    }
}