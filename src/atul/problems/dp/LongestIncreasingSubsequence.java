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

    /* lis() returns the length of the longest increasing
   subsequence in arr[] of size n */
    static int lis_dynamic(int arr[],int n)
    {
        int lis[] = new int[n];
        int i,j,max = 0;

          /* Initialize LIS values for all indexes */
        for ( i = 0; i < n; i++ )
            lis[i] = 1;

           /* Compute optimized LIS values in bottom up manner */
        for ( i = 1; i < n; i++ )
            for ( j = 0; j < i; j++ )
                if ( arr[i] > arr[j] && lis[i] < lis[j] + 1)
                    lis[i] = lis[j] + 1;

           /* Pick maximum of all LIS values */
        for ( i = 0; i < n; i++ )
            if ( max < lis[i] )
                max = lis[i];

        return max;
    }

    public static void main(String args[]){
        int arr[] = {1,3,2,0,10,2,1,4,5,2,6,8};
        System.out.println("lis is "+lis(arr, arr.length));
    }
}