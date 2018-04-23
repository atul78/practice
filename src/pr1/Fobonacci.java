package pr1;

import java.util.Arrays;

/**
 * Created by agosain on 3/28/18.
 */
public class Fobonacci {
   public static int fib(int num){
       if(num<=1)
           return num;
       return fib(num-1)+fib(num-2);
   }

   public static int fibD(int num, int[] mem){
       if(mem[num]!=-1)
           return mem[num];
       if(num<=1)
            mem[num] = num;
       else mem[num] = fibD(num-1, mem)+fibD(num-2, mem);
       return mem[num];
   }

   public static int fibDi(int num){
       int[] mem = new int[num+1];
       mem[0] = 0;
       mem[1] = 1;
       for(int i=2;i<=num;i++){
         mem[i] = mem[i-1]+mem[i-2];
       }

       return mem[num];
   }

   // Space optimized
   public static int fibDSp(int num){
      int a=0, b=1, c=0;
      if(num==0 || num==1) return num;

      for(int i=2;i<=num;i++){
          c = a+b;
          a=b;
          b=c;
      }

      return c;
      
   }

    public static void main(String args[]){
       int num = 7;
       int[] arr = new int[num+1];
        Arrays.fill(arr,-1);
       System.out.println("Fib is "+fibDSp(num));
    }
}

//5
//fib(4)+fib(3)
//fib(3)+fib(2)+fib(2)+fib(1)
//fib(2)+fib(1)+fib(1)+fib(0)+fib(1)+fib(0)+1
//fib(1)+fib(0)+1+1+1+1
//1+1+1+1+1+1 = 8
//
//0,1,1,2,3,5,8
