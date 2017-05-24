package atul.problems;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by agosain on 5/17/2017.
 */
public class RepeatingNumbers {
    public static Set getRepeating(int[] numbers){
        Set returned = new HashSet<Integer>();
        for(int i=0;i<numbers.length;i++){
            if(numbers[i]==-1) {
                returned.add(i);
            }
            else {
                numbers[numbers[numbers[i]]] = numbers[numbers[i]];
                numbers[numbers[i]] = -1;

            }
        }

        return returned;
    }

    public static void main(String args[]){
        int[] numbers = new int[]{1,2,3,0,3,1,5,5,6,7,5,6};
        Set repeated = getRepeating(numbers);
        System.out.println(repeated);
    }
}
