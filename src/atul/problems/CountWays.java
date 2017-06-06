package atul.problems;

import java.util.Arrays;

/**
 * Created by agosain on 5/29/2017.
 * TripleStep: A child is running up a staircase with n steps and can hop either 1,2, or 3 steps at a time.
 * Implement a method to count how many possible ways the child can run up the steps.
 */
public class CountWays {
    public static int numberOfWays(int n) {
        int[] memo = new int[n+1];
        Arrays.fill(memo,-1);
        return numberOfWays(n, memo);
    }

    public static int numberOfWays(int n, int[] memo) {
        if (n < 0)
            return 0;
        else if (n == 0)
            return 1;
        else if(memo[n]!=-1)
            return memo[n];
        else {
            memo[n] = numberOfWays(n - 1, memo) + numberOfWays(n - 2, memo) + numberOfWays(n - 3, memo);
            return memo[n];
        }
    }

    public static void main(String args[]){
        System.out.println(numberOfWays(4));
    }
}
