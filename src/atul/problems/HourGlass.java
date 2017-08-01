package atul.problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by agosain on 7/1/2017.
 */
public class HourGlass {
    public static int[][] convert(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] array = new int[6][];
        int numLine = 0;
        while (sc.hasNextLine()) {
            String line = sc.nextLine();

            array[numLine] = new int[6];
            Scanner sc2 = new Scanner(line);
            int index = 0;
            while (sc2.hasNextInt())
                array[numLine][index++] = sc2.nextInt();
            numLine++;
        }
        return array;
    }

    public static int[][] getIt() {
        int[][] array = new int[6][6];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                int random = (int) (Math.random() * 9);
                array[i][j] = random;
            }
        }

        return array;
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution.
        */
        int[][] array = getIt();
        int maxHrValue = findMaxHourGlass(array);
        System.out.println(maxHrValue);

    }

    public static int findMaxHourGlass(int[][] arr) {
        List<Integer> hrValues = new ArrayList<>();
        int hrValue = 0;
        int maxHrValue = Integer.MIN_VALUE;
        for (int col = 0; col < 4; col++) {
            for (int row = 0; row < 4; row++) {
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (i == 1) {
                            if (j == 1)
                                hrValue += arr[row + i][col + j];
                        } else
                            hrValue += arr[row + i][col + j];
                    }
                }
                maxHrValue = hrValue > maxHrValue ? hrValue : maxHrValue;
                hrValue = 0;
            }
        }

        return maxHrValue;
    }
}
