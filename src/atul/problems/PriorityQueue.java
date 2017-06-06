package atul.problems;

import java.util.Collections;

/**
 * Created by agosain on 5/29/2017.
 */
public class PriorityQueue {
    public static void main(String args[]){
        java.util.PriorityQueue<Integer>  q = new java.util.PriorityQueue<>();
        int[] nums = new int[]{1,2,3,10,100,87,65,44,0,-1};
        for(int i=0;i<nums.length;i++){
            q.add(nums[i]);
        }

        for(Integer i = null; (i = q.poll())!=null; System.out.println(i));
    }
}
