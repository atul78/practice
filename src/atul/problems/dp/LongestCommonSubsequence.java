package atul.problems.dp;

/**
 * Created by agosain on 11/8/17.
 */
public
class LongestCommonSubsequence {

    public static void main(String args[]){
        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";

        System.out.println(lcs(s1,s2,s1.length(),s2.length()));
    }

    public static int lcs(String s1, String s2, int l1, int l2){
        if(l1==0 || l2==0)
            return 0;

        if(s1.charAt(l1-1)==s2.charAt(l2-1)){
            return 1+lcs(s1, s2, l1-1, l2-1);
        }

        return Math.max(lcs(s1, s2, l1-1, l2), lcs(s1, s2, l1, l2-1));
    }
}