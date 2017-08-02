package atul.problems.dp;

/**
 * Created by agosain on 5/23/2017.
 */
public class MakeChange {
    public static int makeChange(int n, int denom){
        System.out.println("Making change for "+n+","+denom);

        int next_denom = 0;
        int ways=0;
        switch(denom) {
            case 25:
                next_denom = 10;
                break;
            case 10:
                next_denom = 5;
                break;
            case 5:
                next_denom = 1;
                break;
            case 1:
                return 1;
        }
        for(int i=0;i*denom <= n;i++){
            ways+=makeChange(n-i*denom, next_denom);
        }

        return ways;
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

    public static int makeChange2(int n){
        int[] denoms = {25,10,5,1};
        return makeChange2(n, denoms, 0);
    }

    public static void main(String args[]){
        System.out.println(makeChange2(100));
    }
}