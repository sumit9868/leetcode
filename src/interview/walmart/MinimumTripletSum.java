package interview.walmart;

public class MinimumTripletSum {
    //array of positive integer arr[]
    //i,j,k
    //i<j<K
    //arr[i]<arr[j]>arr[k]
    // sum is minimum
    // 10^5

//    List<> left, element less than j
//    List<> right, element less than j

//    j
//    n-1 ... j+1 add num<arr[j]
//    0   ... j-1 add num<arr[j]

    public static void main(String[] args) {
        int[] arr = {5,4,8,7,10,2};
        System.out.println(getMinTriplet(arr));
    }

    public static int getMinTriplet(int[]arr){
        int left[] = new int[arr.length];
        int right[] = new int[arr.length];

        //left
        left[0] = arr[0];
        for(int i=1;i<arr.length;i++){
            left[i] = Math.min(arr[i],left[i-1]);
        }
        //right
        right[arr.length-1] = arr[arr.length-1];
        for(int i=arr.length-2;i>=0;i--){
            right[i] = Math.min(arr[i],right[i+1]);
        }
        int sum = Integer.MAX_VALUE;
        for(int i=1;i< arr.length-1;i++){
            if(arr[i]<=left[i-1]||arr[i]<=right[i+1]) continue;
            sum = Math.min(sum, arr[i]+left[i-1]+right[i+1]);
        }

        return sum;
    }
}
