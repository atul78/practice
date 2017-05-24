package atul.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by agosain on 5/5/2017.
 */
public class Permutations {
    public static List<String> getPerms(String str) {
        List<String> permutations = new ArrayList<String>();
        if (str == null)
            return null;
        if (str.length() == 0) {
            permutations.add("");
            return permutations;
        }
        char first = str.charAt(0);
        String remainder = str.substring(1);
        List<String> words = getPerms(remainder);
        for(String word: words){
            for(int j=0;j<=word.length();j++)
                permutations.add(insertCharAt(word, first, j));
        }

        return permutations;
    }

    public static String insertCharAt(String word, char c, int i){
        String start = word.substring(0,i);
        String end = word.substring(i);
        return start+c+end;
    }

    public static void main(String args[]){
        String str = "abc";
        List<String> perms = getPerms(str);
        System.out.println(perms);
    }
}