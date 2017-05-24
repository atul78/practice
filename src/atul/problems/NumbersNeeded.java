package atul.problems;

/**
 * Created by agosain on 5/23/2017.
 */
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
public class NumbersNeeded {
    public static int numberNeeded(String first, String second) {
        int[] chars = new int[26];
        //Arrays.fill(chars,0);
        int count = 0;
        char[] firstChars = first.toCharArray();
        char[] secondChars = second.toCharArray();

        for(char c : firstChars){
            chars[c-'a']++;
        }
        for(char c : secondChars){
            chars[c-'a']--;
        }
        for(int i=0;i<chars.length;i++){
            if(chars[i]!=0){
                count++;
                System.out.println("Need to remove "+(char)(i+'a'));
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = "cde";
        String b = "abc";
        System.out.println("Result is "+numberNeeded(a, b));
    }
}
