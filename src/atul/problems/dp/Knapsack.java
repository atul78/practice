package atul.problems.dp;

/**
 * Created by agosain on 11/8/17.
 */
public
class Knapsack {
    public static
    void main(String[] args) {
        int val[] = new int[]{60, 100, 120};
        int wt[] = new int[]{10,20,30};
        int W = 50;
        int n = val.length;
        System.out.println(knapsack(W, wt, val, n));
    }

    public static int knapsack(int W, int[] wt, int[] val, int n){
        if(n==0 || W==0)
            return 0;

        if(wt[n-1]>W)
            return knapsack(W, wt, val, n-1);

        else return Math.max(val[n-1] + knapsack(W-wt[n-1], wt, val, n-1), knapsack(W, wt, val, n-1));


    }
}
