package atul.problems.dp;

/**
 * Created by agosain on 11/8/17.
 */
public
class EditDistance {

    public static int edit(String s1, String s2, int l1, int l2){
        if(s1.length()==0)
            return l2;
        if(s2.length()==0)
            return l1;

        if(s1.charAt(l1-1)==s2.charAt(l2-1))
            return edit(s1,s2, l1-1, l2-1);

        return 1+min(edit(s1, s2, l1-1, l2),
                     edit(s1, s2, l1, l2-1),
                     edit(s1, s2, l1-1, l2-1));
    }

    static int editDist(String str1 , String str2 , int m ,int n)
    {
        // If first string is empty, the only option is to
        // insert all characters of second string into first
        if (m == 0) return n;

        // If second string is empty, the only option is to
        // remove all characters of first string
        if (n == 0) return m;

        // If last characters of two strings are same, nothing
        // much to do. Ignore last characters and get count for
        // remaining strings.
        if (str1.charAt(m-1) == str2.charAt(n-1))
            return editDist(str1, str2, m-1, n-1);

        // If last characters are not same, consider all three
        // operations on last character of first string, recursively
        // compute minimum cost for all three operations and take
        // minimum of three values.
        return 1 + min ( editDist(str1,  str2, m, n-1),    // Insert
                         editDist(str1,  str2, m-1, n),   // Remove
                         editDist(str1,  str2, m-1, n-1) // Replace
        );
    }

    private static int min(int n1, int n2, int n3){
        return Math.min(n1, Math.min(n2, n3));
    }

    public static void main(String args[]){
        String str1 = "Saturday";
        String str2 = "Sunday";

        System.out.println("Number of char changes needed "+editDist(str1, str2, str1.length(), str2.length()));
    }
}
