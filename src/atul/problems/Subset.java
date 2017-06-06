package atul.problems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by agosain on 5/5/2017.
 */
public class Subset {
    public static void main(String args[]){
        List<String>  alphas = new ArrayList<String>();
        alphas.add("a");
        alphas.add("b");
        alphas.add("c");
        alphas.add("d");
        System.out.println(getSubsets(alphas));

    }

    public static List<List<String>> getSubsets(List<String> set){
        List<List<String>> allSubsets = null;
        if(set.size()==0){
            allSubsets = new ArrayList<List<String>>();
            allSubsets.add(new ArrayList<String>());
            return allSubsets;
        }

        String first = set.remove(0);
        allSubsets = getSubsets(set);
        List<List<String>> moreSubsets = new ArrayList<List<String>>();
        for(List<String> subset: allSubsets){
            List<String> newSubset = new ArrayList<>();
            newSubset.addAll(subset);
            newSubset.add(first);
            moreSubsets.add(newSubset);
        }
        allSubsets.addAll(moreSubsets);

        return allSubsets;
    }

}
