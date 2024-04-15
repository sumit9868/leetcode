package BFS;

import java.util.LinkedList;
import java.util.Queue;

public class CoinChange {
    class Pair{
        int target;
        int count;
        public Pair(int t,int c){
            target =t;
            count =c;
        }
    }
    public int coinChange(int[] coins, int amount) {
        int min = Integer.MAX_VALUE;
        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(amount,0));

        while(!q.isEmpty()){
            Pair pair = q.remove();

            if(pair.target==0){
                min = Math.min(min,pair.count);
                break;
            }

            for(int coin: coins){
                if(pair.target-coin>=0){
                    q.add(new Pair(pair.target-coin,pair.count+1));
                }
            }
        }

        if(min == Integer.MAX_VALUE) return -1;
        return min;
    }

    public static void main(String[] args) {
        int[] coins = {1,2,5};
        int amount = 11;
        System.out.println(new CoinChange().coinChange(coins,amount));
    }
}
