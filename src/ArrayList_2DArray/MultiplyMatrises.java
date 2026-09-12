package ArrayList_2DArray;

import java.util.Scanner;

public class MultiplyMatrises {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter row of matrix A : ");
        int r1 = sc.nextInt();

        System.out.print("Enter column of Matrix A : ");
        int c1 = sc.nextInt();

        System.out.print("Enter row of matrix B : ");
        int r2 = sc.nextInt();

        System.out.print("Enter column of Matrix B : ");
        int c2 = sc.nextInt();

        if(c1 != r2){
            System.out.print("Matrix Multiplication is not possible ");
            return;
        }

        int[][] A = new int[r1][c1];
        int[][] B = new int[r2][c2];
        int[][] C = new int[r1][c2];

        System.out.print("Enter First Matrixes Element : ");
        for(int i=0; i<r1; i++){
            for(int j=0; j<c1; j++){
                A[i][j] = sc.nextInt();
            }
        }

        for(int i=0; i<r2; i++){
            for(int j=0; j<c2; j++){
                B[i][j] = sc.nextInt();
            }
        }

        for(int i=0; i<r1; i++) {
            for (int j = 0; j < c2; j++) {

                C[i][j] = 0;

                for(int k =0; k<c1; k++){

                    C[i][j] = C[i][j] + A[i][k] * B[k][j];
                }
            }
        }

        System.out.print("Result of Matrix multipllication is : ");
        for(int i = 0; i<r1; i++){
            for(int j = 0; j<c2; j++){
                System.out.print(C[i][j]+" ");
            }

            System.out.print("\n");
        }
    }
}