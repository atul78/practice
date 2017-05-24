package atul.bits;

/**
 * Created by agosain on 4/24/2017.
 */
public class NumberOfOnes {
    public int numberOf1s(long number){
        int count = 0;
        while(number>0){
            number &= number-1;
            count++;
        }
        return count;
    }

    public static boolean isBitSet(int number, int place){
        return ((number & (1 << place))>>place == 1);
    }

    public static int setBit(int number, int place){
        return (number | 1<<place);
    }

    public static byte[] showBinary(int number){
        byte[] bytes = new byte[32];
        for(int i=0;i<bytes.length-1;i++)
            bytes[bytes.length-1-i] = (byte)((number & (1<<i))>>i);

        System.out.print("\n"+number+"=");
        for (int i = 0; i < bytes.length; i++)
            System.out.print(bytes[i]);

        return bytes;
    }

    public static byte compliment(byte number){
        return number;
    }

    public static void main(String args[]){
        NumberOfOnes c = new NumberOfOnes();
        System.out.println(c.numberOf1s(24));

        System.out.println(isBitSet(4,2));
        for(int i=0;i<32;i++){
            System.out.println(i+"="+setBit(0,i));
        }

        for(int num=1;num<10;num++)
            showBinary(num);

        byte b = -7;
        showBinary(~b);

        System.out.println("\n"+(b^7^7^7^7));

    }
}