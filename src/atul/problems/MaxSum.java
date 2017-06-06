package atul.problems;

/**
 * Created by agosain on 5/24/2017.
 */
public class MaxSum {
    public static int getMaxSum(int[] a){
        int maxSum = 0;
        int sum = 0;
        for(int i=0;i<a.length;i++){
            sum += a[i];
            if(sum>maxSum)
                maxSum = sum;
            else if(sum<0)
                sum = 0;
        }
        return maxSum;
    }

    public static void main(String args[]){
        int[] input = {2,-8,3,-2,4,-10};
        System.out.println(getMaxSum(input));
    }
}
