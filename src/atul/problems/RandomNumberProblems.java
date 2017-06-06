package atul.problems;

import java.util.Random;
import java.util.stream.IntStream;

/**
 * Generate a random 4-digit even number : the adjacent 2 digits must be different.
 public int getNumber(){
 }
 1000,1002,1004,1010,1012,1014,1016,1018,1020,
 * Created by agosain on 6/3/2017.
 */
public class RandomNumberProblems {
    public static int getNumber(){

        int number = -1;
        while((number = (int)(Math.random()*10000))>1000 ) {

            if(number%2!=0)
                continue;
            int thousandsDigit = number / 1000;
            int hundredsDigit = (number % 1000) / 100;
            int tensDigit = ((number % 1000) % 100) / 10;
            int onesDigit = number % 10;
            System.out.println(thousandsDigit + "" + hundredsDigit + "" + tensDigit + "" + onesDigit);
            break;
        }
        return number;
    }

    public static int fib(int number, int memo[]){
        if(number==0) return 1;
        if(number==1) return 1;
        if(memo[number-1]!=0)
            return memo[number-1];
        memo[number-1] = fib(number-1, memo)+fib(number-2, memo);
        return memo[number-1];
    }

    public static boolean isPerfectSquare(int num){
        int root = (int)Math.floor((Math.sqrt(num)));
        return root*root==num;
    }

    public static boolean isFib(int number){
        return isPerfectSquare(5*number*number-4) || isPerfectSquare(5*number*number+4);
    }

    public static int fib(int number){
        if(number==0)
            return 0;
        if(number==1)
            return 1;
        return fib(number-1)+fib(number-2);
    }

    // write a function that randomly return a random Fibonacci number in range [min, max)
    public int getRandom (int min, int max){
        return 0;
    }

    public static int countUniqueRandomNumsBetween(int min, int max){
        return 0;
    }

    public static int generateRandomFib(int min, int max){
        if(max<min)
            return -1;
        int value;
        do {
            value = new Random().nextInt(max-min)+min;
        }while(!isFib(value));

        return value;
    }

    public static int generate() {
        Random rnd = new Random();
        int value;
        do {
            value = 1013 + rnd.nextInt(9898 - 1013);
        } while ((value & 1) == 1 ||
                value % 10 == value % 100 / 10  ||
                value % 100 / 10 == value % 1000 / 100 ||
                value % 1000 / 100 == value % 10000 / 1000);
        return value;
    }

    public static void main(String args[]){
        System.out.println(generate());
        System.out.println(fib(6, new int[6]));
        System.out.println(isFib(13));
        System.out.println(generateRandomFib(10,50));
    }
}
