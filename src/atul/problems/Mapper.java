package atul.problems;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Mapper {
    char[] map = new char[26];
    public Mapper(){
        for(int i=0;i<map.length;i++){
            map[i] = (char)('a'+i);
        }
    }

    public List<String> mapNumbers(String numbers, int start){
        int[] nums = getNumbers(numbers, start);
        int first = nums[0];
        int second = nums[1];
        int combined = first*10+second;
        String mapped = map[0];
        return null;
    }

    int[] getNumbers(String numbers, int start){
        if(numbers.length()==0){
            return null;
        }
        numbers = numbers.substring(0);
        int number = Integer.valueOf(numbers);
        int multiplier = number;
        int remainder = 0;
        while(number>10){
            multiplier = number/10;
            remainder = number%10;
            number = number/10;
        }
        int first = number;
        int second = remainder;
        return new int[]{first, second};
    }

    @Test
    public void testMapNumber(){
        String number = "45855";
        int[] converted = getNumbers(number);
        assertEquals(4, converted[0]);
        assertEquals(5, converted[1]);
    }
}
