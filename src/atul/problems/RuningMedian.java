package atul.problems;

import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by agosain on 7/27/2017.
 */
public class RuningMedian {
    static java.util.PriorityQueue<Integer> maxHeap = new java.util.PriorityQueue<>(1);
    static java.util.PriorityQueue<Integer> minHeap = new java.util.PriorityQueue<>(1, Comparator.reverseOrder());

    public static void addNum(int num){
        if(maxHeap.size()==minHeap.size()){
            if(minHeap.peek()!=null && num > minHeap.peek()){
                maxHeap.add(minHeap.poll());
                minHeap.add(num);
            }else
                maxHeap.add(num);
        }
        else{
            if(num > maxHeap.peek())
                minHeap.add(num);
            else{
                minHeap.add(maxHeap.poll());
                maxHeap.add(num);
            }
        }
    }

    public static double getMedian(){
        if(maxHeap.size()==minHeap.size())
            return ((double)maxHeap.peek()+(double)minHeap.peek())/2;

        return (double)maxHeap.peek();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
            addNum(a[a_i]);
            System.out.println(getMedian());
        }

        // Calculate the median

    }

}
