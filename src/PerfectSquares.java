import java.util.*;

public class PerfectSquares {
    Set<Integer> squares;
    public HashMap<String,Integer>map;
    public class Pair{
        int count;
        int target;
        public Pair(int t,int c){
            count = c;
            target = t;
        }
    }
    public int numSquares(int n) {
        Set<String> map = new HashSet<>();
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(n,0));
        int min = Integer.MAX_VALUE;
        squares = new HashSet<>();
        for(int i=1;i*i<=n;i++)squares.add(i*i);
        while(!q.isEmpty()){
            Pair pair = q.remove();
            if(pair.target==0){
                min=Math.min(min, pair.count);
            }
            if(squares.contains(pair.target)){
                min=Math.min(min, pair.count+1);
                break;
            }
            for(int i=1;i*i<= pair.target;i++){
                String key = (pair.target-i*i)+"|"+(pair.count+1);
                if(map.contains(key))continue;
                q.add(new Pair(pair.target-i*i,pair.count+1));
                map.add(key);
            }
        }
        return min;
    }

    public static void main(String[] args) {
        int nums[] = {12,13,318};
        PerfectSquares perfectSquares = new PerfectSquares();
        for(int n:nums) {
            System.out.println(n+" "+perfectSquares.numSquares(n));
        }
    }
}
