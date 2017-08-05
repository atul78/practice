package atul.problems;

import java.util.*;

public class RunningMedian {
    static java.util.PriorityQueue<Integer> maxHeap = new java.util.PriorityQueue<>(1, Collections.reverseOrder());
    static java.util.PriorityQueue<Integer> minHeap = new java.util.PriorityQueue<>(1);

    public static double findMedian(int newInt){
        double median = 0;
        if(maxHeap.size() == minHeap.size() ){
            if(maxHeap.peek()!=null){
                if(maxHeap.peek()>newInt)
                    maxHeap.add(newInt);
                else{
                    maxHeap.add(minHeap.poll());
                    minHeap.add(newInt);
                }
                return maxHeap.peek();
            }else {
                maxHeap.add(newInt);
                return maxHeap.peek();
            }
        }


        if(maxHeap.size() > minHeap.size()){
                if(newInt<maxHeap.peek()){
                    minHeap.add(maxHeap.peek());
                    maxHeap.add(newInt);
                }else
                    minHeap.add(newInt);

            median = ((double)maxHeap.peek()+(double)minHeap.peek())/2;
        }

        return median;

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];

        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
            System.out.println(findMedian(a[a_i]));
        }
    }
}
