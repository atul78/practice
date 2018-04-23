package atul.problems;

/**
 * Created by agosain on 3/25/18.
 */
public
class ReverseAString {
    public static String reverse(String str){
        String reversed = new String();
        for(int i=str.length()-1;i>=0;i--)
            reversed+=str.charAt(i);

        return reversed;
    }

    public static void main(String args[]){
        System.out.println("Reverse of abcd is "+reverse("abcd"));
    }
}
