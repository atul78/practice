package atul.problems;

import java.util.*;

/**
 * Created by agosain on 6/5/2017.
 */
public class WeightedSampling<T> {

    public T getNumPerWeight(List<WeightedObjects<T>> list) {
        int sum = 0;
        int[] weightedSums = new int[list.size()];
        int i = 0;
        Map<Integer, T> map = new HashMap<>();
        for (WeightedObjects<T> obj : list) {
            sum += obj.weight;
            weightedSums[i++] = sum;
            map.put(sum, obj.obj);
        }

        int random = new Random().nextInt(weightedSums[weightedSums.length - 1]);
        int low = 0;
        int high = weightedSums.length;
        int mid = 0;
        while (low < high) {
            mid = low + high / 2;
            if (random == weightedSums[mid])
                return map.get(weightedSums[mid]);
            else if (random < weightedSums[mid]) {
                if (random > weightedSums[mid==0 ? mid:mid - 1])
                    return map.get(weightedSums[mid]);
                else {
                    high = mid - 1;
                    continue;
                }
            } else if (random > weightedSums[mid]) {
                if (random < weightedSums[mid==weightedSums.length ? mid:mid + 1])
                    return map.get(weightedSums[mid + 1]);
                else {
                    low = mid + 1;
                    continue;
                }
            }
        }

        return null;
    }

    public static void main(String args[]){
        WeightedObjects obj1 = new WeightedObjects<Character>('A',1);
        WeightedObjects obj2 = new WeightedObjects<Character>('B',10);
        WeightedObjects obj3 = new WeightedObjects<Character>('C',40);
        WeightedObjects obj4 = new WeightedObjects<Character>('D',2);

        List<WeightedObjects<Character>> list = new ArrayList<>();
        list.add(obj1);
        list.add(obj2);
        list.add(obj3);
        list.add(obj4);
        WeightedSampling sampling = new WeightedSampling();
        for(int i=0;i<100;i++)
            System.out.print(sampling.getNumPerWeight(list));
    }
}

class WeightedObjects<T>{
    T obj;
    int weight ;
    WeightedObjects(T obj, int weight){
        this.obj = obj;
        this.weight = weight;
    }
}
