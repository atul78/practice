package atul.problems;

/**
 * Created by agosain on 5/4/2017.
 */
public class MultipleOfTwo {
    public static boolean isMultipleOfTwo(int number, int multipleOf){
        boolean isMultiple = false;
        return number%multipleOf==0;
    }
    public static boolean isPowerOf(int number, int powerOf){
        while(number%powerOf==0) number /= powerOf;
        return number==1;
    }

    public static boolean powerOfTwo(int number){
        return (number & (number-1))==0;
    }
    public static boolean isPrime(int number){
        if(number<=0)
            return false;
        if(number==2)
            return true;
        for(int i=3;i<number;i++){
            if(number%i==0)
                return false;
        }
        return true;
    }

    public static int getPowerOf(int num, int exponent){
        int total = 1;
        if(num<=0)
            return total;
        if(num==1)
            return 1;
        for(int i=0;i<exponent;i++)
            total*=num;
        return total;
    }

    public static long getPowerOfRec(int num, int exponent){
        if(exponent==0)
            return 1;
        if(exponent==1)
            return num;
        System.out.println("exponent:"+exponent);
        if(isPrime(exponent)){
            return getPowerOf(num,exponent);
        }

        boolean flag = false;
        long total =  getPowerOfRec(num,exponent/2);
        total *= total;
        if(exponent%2!=0)
            total = total * num;

        return total;
    }

    public static void main(String args[]){
        System.out.println(isPowerOf(49,7));
        System.out.println(isPrime(13));
        System.out.println(getPowerOfRec(2,27));
        System.out.println(4%10);
    }
}
