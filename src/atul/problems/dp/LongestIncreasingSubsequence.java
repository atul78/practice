package atul.problems.dp;

public class LongestIncreasingSubsequence {
    static int max_ref;
    public static int _lis(int[] arr, int n){
        if(n==1)
            return 1;
        int res, max_ending_here = 1;

        for(int i=0;i<n;i++){
            res = _lis(arr, i);
            if(arr[i-1] < arr[n-1])
                max_ending_here = res +1;
        }

        if(max_ref < max_ending_here)
            max_ref = max_ending_here;

        return max_ending_here;
    }

    static int lis(int arr[], int n){
       max_ref = 1;
       return _lis(arr, n);
    }

    public static void main(String args[]){
        int arr[] = {1,3,2,0,10,2,1,4,5,2,6,8};
        System.out.println("lis is "+lis(arr, arr.length));
    }
}
