package interview.walmart;

import java.util.*;

public class MergeTwoList {
    private static List<Integer> mergedLists(List<Integer> list1, List<Integer> list2){
        List<Integer> ans = new ArrayList<>();
        int i,j;
        i=0;
        j=0;

        while(i<list1.size() && j<list2.size()){
            if(list1.get(i)<=list2.get(j)){
                ans.add(list1.get(i));
                i++;
            }else {
                ans.add(list2.get(j));
                j++;
            }
        }

        while(i<list1.size()){
            ans.add(list1.get(i));
            i++;
        }
        while(j<list2.size()){
            ans.add(list2.get(j));
            j++;
        }

        return ans;
    }
    public static void main(String[] args) {
        List<Integer> list1 = List.of(1,2,3,4,5);
        List<Integer> list2 = List.of(1,4,6,8);
        //both list are in increasing order


        System.out.println(mergedLists(list1,list2));
    }

}
