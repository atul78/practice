package atul.bits;

/**
 * Created by agosain on 5/10/2017.
 */
public class ReplaceBits {
    public static int replaceBits(int n1, int n2, int start, int end){
        int result = 0;
        if(start>32 || end > 32)
            return -1;


        return result;
    }

    public static void main(String args[]){
        int max = ~0;
        int i=2;
        int j=9;
        int left = max - ((1<<j)-1);
        int right = (1<<i)-1;
        int mask = left | right;

    }
}
