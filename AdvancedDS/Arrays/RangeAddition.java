package Arrays;

import java.util.*;

public class RangeAddition {

    // This is a functional problem. You have to complete this function.
    // It takes as input a length and a 2D array of update operations.
    // It should return the modified array.
    public static int[] getModifiedArray(int length, int[][] updates) {

        int equiupdate[] = new int[length + 1];
        int result[] = new int[length];

        for (int i = 0; i < updates.length; i++) {
            int left = updates[i][0];
            int right = updates[i][1];
            int inc = updates[i][2];

            equiupdate[left] += inc;
            equiupdate[right + 1] -= inc;
        }

        result[0] = equiupdate[0];

        for (int i = 1; i < result.length; i++) {
            result[i] = result[i - 1] + equiupdate[i];
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input for length of first array.
        int length = sc.nextInt();

        int K = sc.nextInt();

        int[][] updates = new int[K][3];

        for (int i = 0; i < updates.length; i++) {
            for (int j = 0; j < updates[0].length; j++) {
                updates[i][j] = sc.nextInt();
            }
        }

        int[] result = getModifiedArray(length, updates);
        display(result);
    }

    // function to display an array.
    public static void display(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.println();
    }

}
