package BitManipulation;

import java.util.Scanner;

public class Subsets {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of array : ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter array elements : ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        findSubsets(arr);
    }

    private static void findSubsets(int[] arr) {

        int n = arr.length;

        int totalSubsets = 1 << n;

        for (int mask = 0; mask < totalSubsets; mask++) {

            System.out.print("[ ");

            for (int i = 0; i < n; i++) {

                if ((mask & (1 << i)) != 0) {
                    System.out.print(arr[i] + " ");
                }
            }

            System.out.println("]");
        }
    }
}
