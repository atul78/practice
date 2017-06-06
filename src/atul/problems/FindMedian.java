package atul.problems;

import java.util.Collections;
import java.util.PriorityQueue;
/**
 * Created by agosain on 5/31/2017.
 */
public class FindMedian {
    static PriorityQueue<Integer> maxHeap = new PriorityQueue<>();
    static PriorityQueue<Integer> minHeap = new PriorityQueue<>(Collections.reverseOrder());
    public static void addNewNumber(int num){
        if(maxHeap.size()==minHeap.size()){
            if(minHeap.peek()!=null && num>minHeap.peek()){
                maxHeap.add(minHeap.poll());
                minHeap.add(num);
            }else
                maxHeap.add(num);
        }else{
            if(num<maxHeap.peek()){
                minHeap.add(maxHeap.poll());
                maxHeap.add(num);
            }
            else{
                minHeap.add(num);
            }
        }
    }

    public static double getMedian(){
        if(maxHeap.isEmpty()) return minHeap.peek();
        else if(minHeap.isEmpty()) return maxHeap.peek();
        if(maxHeap.size() == minHeap.size())
            return (minHeap.peek()+maxHeap.peek())/2;
        else if(maxHeap.size()>minHeap.size())
            return maxHeap.peek();
        else
            return minHeap.peek();
    }

    public static void main(String args[]){

        int[] nums = new int[]{6,12,4,5,3,8,7};
        //System.out.println(findMedian(nums));
    }
}
