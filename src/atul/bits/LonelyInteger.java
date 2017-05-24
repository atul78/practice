package atul.bits;

/**
 * Created by agosain on 5/3/2017.
 */
public class LonelyInteger {
    public static int findLonely(int[] numbers){
        int lonely = 0;
        if(numbers==null || numbers.length==0)
            return lonely;

        for(int number: numbers){
            lonely ^= number;
        }
        return lonely;
    }

    public static void main(String args[]){
        int[] nums = new int[]{1,2,3,4,5,4,3,2,1,5,10};
        System.out.println("Lonely int is "+findLonely(nums));

    }
}
