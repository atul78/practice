package atul.problems;

/**
 * Created by agosain on 5/17/2017.
 */
public class LargestSumArr {
    public static int[] getSubsetWithLargestSum(int[] numbers){
        int[] returnArr = new int[numbers.length];

        int maxTotal = 0;
        for(int i=0;i<numbers.length;i++){
            int total = maxTotal + numbers[i];
            if(total+maxTotal>maxTotal) {
                maxTotal += total;
                returnArr[i] = numbers[i];
            }else{
                // Reset the return array
                returnArr = new int[numbers.length];
            }


        }

        return null;
    }
}
