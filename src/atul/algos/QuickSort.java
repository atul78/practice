package atul.algos;

/**
 * Created by agosain on 4/28/2017.
 */
public class QuickSort {
    public static void main(String args[]){
        int[] arr = new int[]{21,11,33, 33, 90,2,3,12};
        new QuickSort().quickSort(arr,0, arr.length-1);
        for(int num : arr){
            System.out.print(num+" ");
        }
    }
    public void quickSort(int[] numbers, int left, int right){
        if(left>=right)
            return;
        int pivot = numbers[(left+right)/2];
        int index = partition(numbers, left, right, pivot);
        quickSort(numbers, left, index-1);
        quickSort(numbers, index, right);
    }

    public static int partition(int[] array, int left, int right, int pivot){
        while(left<=right){
            while(array[left]<pivot)
                left++;
            while(array[right]>pivot)
                right--;

            if(left<=right){
                swap(array, left, right);
                left++;
                right--;
            }
        }
        return left;
    }

    public static void swap(int[] numbers, int i, int j){
        int temp = numbers[i] ;
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }


}
