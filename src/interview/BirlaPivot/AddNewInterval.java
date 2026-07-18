package interview.BirlaPivot;

import java.util.*;

public class AddNewInterval {
    /**
     *
     *
     *
     * You are given an array of non-overlapping intervals,
     * intervals where intervals[i] = [starti, endi] represent the start and the end of the ith interval and
     * intervals is sorted in ascending order by starti.
     * You are also given an interval newInterval = [start, end] that represents the start and end of another interval.
     * Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals
     * still does not have any overlapping intervals (merge overlapping intervals if necessary).
     * Return intervals after the insertion.
     * Note that you don't need to modify intervals in-place.
     * You can make a new array and return it.
     *
     * Example 1:
     * Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
     * Output: [[1,5],[6,9]]
     *
     * stack - {[1,5]}
     *  */

    private static List<int[]> addNewInterval(int[][] intervals, int[] newInterval){
        List<int[]> ans = new ArrayList<>();
        Stack<int[]> stk = new Stack<>();
//        stk.add(newInterval);
        int idx = 0;
        int[] peek;
        while(idx<intervals.length){

            peek= stk.isEmpty()?null:stk.peek();

            int[] curr=newInterval;
            if(curr==null || newInterval[0]>intervals[idx][0]){
                curr = intervals[idx];
                idx++;
            }else{
                newInterval=null;
            }

            while(peek !=null && canMerge(curr,peek)){
                stk.pop();
                curr = merge(curr,peek);
                peek = null;
                if(!stk.isEmpty())peek = stk.peek();
            }

            stk.push(curr);
//            idx++;
        }

        while(!stk.isEmpty()){
            ans.addFirst(stk.pop());
        }

        return ans;
    }

    private static boolean canMerge(int[] a, int [] b){
        if(a[0]>b[0])return canMerge(b,a);
        return a[1] >= b[0];
    }

    private static int[] merge(int[]a, int[]b){
        if(a[0]>b[0])return merge(b,a);
        return new int[]{a[0],Math.max(a[1],b[1])};
    }
    public static void main(String[] args) {
        int[][]intervals = {
                {1, 3},{6,9}
        };
        int[] newInterval = {2,5};
        for(int[] row: addNewInterval(intervals,newInterval)){
            System.out.println(Arrays.toString(row));
        }
    }
}
