import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class SwimInRisingWater {
    int[] X={-1,1,0,0};
    int[] Y={0,0,-1,1};
    public class Pair implements Comparable<Pair>{
        int i;
        int j;
        int t;
        public Pair(int x, int y, int time){
            i=x;
            j=y;
            t=time;
        }

        @Override
        public int compareTo(Pair o) {
            return this.t-o.t;
        }

        @Override
        public String toString(){
            return "["+i+","+j+","+t+"]";
        }
    }
    public int swimInWater(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0,0,grid[0][0]));
        Set<String> visited = new HashSet<>();
        int max = -1;
        while(!pq.isEmpty()){
            Pair pair = pq.poll();
            max = Math.max(pair.t,max);
            System.out.println(pair);

            if(pair.i == row-1 && pair.j == col-1) return max;

            for(int k=0;k<4;k++){
                int x = pair.i + X[k];
                int y = pair.j + Y[k];
                if(x>=0 && y>=0 && x<row && y<col){
                    if(visited.contains(x+"|"+y))continue;
                    visited.add(x+"|"+y);
                    pq.add(new Pair(x,y,grid[x][y]));
                }
            }
        }
        return max;
    }
    public static void main(String[] args) {
        int[][] grid = {
                {0, 1, 2, 3, 4},
                {24, 23, 22, 21, 5},
                {12, 13, 14, 15, 16},
                {11, 17, 18, 19, 20},
                {10, 9, 8, 7, 6}
        };
        System.out.println(new SwimInRisingWater().swimInWater(grid));
    }
}
