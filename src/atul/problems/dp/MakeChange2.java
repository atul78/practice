package atul.problems.dp;

import java.util.*;

public class MakeChange2 {

    static long getWaysRec(long n, int m, long[] c){
        // Complete this function
        if(n==0)
            return 1;
        if(n<0)
            return 0;
        if(m<=0)
            return 0;
        return getWaysRec(n,m-1,c)+getWaysRec(n-c[m-1], m, c);
    }

    static long getWays(int n, int m, int[] c){
        long[] table = new long[n+1];
        Arrays.fill(table, 0l);
        table[0] = 1;
        for(int i=0; i< m; i++)
            for(int j=c[i]; j<=n;j++) {
                System.out.printf("i=%d, j=%d \n", i, j);
                System.out.printf("table[%d] = %d \n",j, table[j]);
                table[j] = table[j] + table[j - c[i]];
            }

        return table[n];
    }

    public static int makeChange2(int amount, int[] denoms, int index){
        System.out.println("Making change for "+amount+":"+denoms[index]);
        if(index>=denoms.length-1) return 1;
        int denomAmount = denoms[index];
        int ways = 0;
        for(int i=0;i*denomAmount <= amount; i++){
            int amountRemaining = amount - i*denomAmount;

            ways += makeChange2(amountRemaining, denoms, index+1);
        }
        return ways;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] c = new int[m];
        for(int c_i=0; c_i < m; c_i++){
            c[c_i] = in.nextInt();
        }
        // Print the number of ways of making change for 'n' units using coins having the values given by 'c'
        long ways = getWays(n, m, c);
        System.out.println(ways);
    }
}