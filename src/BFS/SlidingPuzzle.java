package BFS;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class SlidingPuzzle {
    int[][] moves = {
            {1, 3},
            {0,2,4},
            {1,5},
            {0,4},
            {1,3,5},
            {2,4}
    };
    /**
     * 123
     * 450
     *
     * 012
     * 345*/
    public class Pair{
        String game;
        int idx;
        int moves;
        public Pair(String g, int i, int m){
            game = g;
            idx = i;
            moves = m;
        }

        @Override
        public String toString(){
            return game+","+idx+","+moves;
        }
    }
    public int slidingPuzzle(int[][] board) {
        //check if cycle is present or not
        String solved = "123450";
        StringBuilder first =new StringBuilder();
        int idx = 0;
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                first.append(board[i][j]);
                if(board[i][j]== 0 ) idx = i*3 +j;
            }
        }
        Set<String> played = new HashSet<>();
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(first.toString(),idx,0));
        while(!q.isEmpty()){
            Pair pair = q.remove();
            if(pair.game.equals(solved)) return pair.moves;
            if(played.contains(pair.game)) continue;
            idx = pair.idx;
            played.add(pair.game);
            for(int swap: moves[idx]){
                StringBuilder sb = new StringBuilder(pair.game);
                sb.setCharAt(swap,'0');
                sb.setCharAt(idx,pair.game.charAt(swap));
                if(played.contains(sb.toString()))continue;
                q.add(new Pair(sb.toString(),swap,pair.moves+1));
            }
        }
        return -1;
    }

//    public String move0(String board,int idx){
//        StringBuilder sb = new StringBuilder(board);
//        return sb.toString();
//    }

    public static void main(String[] args) {
//        int[][] board = {{1, 2, 3}, {4, 0, 5}};
//        int[][] board = {{1, 2, 3},{5, 4, 0}};
        int[][] board = {{4, 1, 2}, {5, 0, 3}};
        System.out.println(new SlidingPuzzle().slidingPuzzle(board));
    }
}
