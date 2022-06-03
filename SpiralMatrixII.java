/*Given an integer A, generate a square matrix filled with elements from 1 to A*A in spiral order. The spiral order will be clockwise in nature starting from (0,0)

Input format
One line of input, containing a single integer A. */

import java.util.*;

class SpiralMatrixII {



    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int result[][] = spiralMatrixII(n);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }

    static int[][] spiralMatrixII(int n) {

        int[][] mat = new int[n][n];
        int count = 0;
        int left = 0 , top = 0 , right = n , bottom = n;

        while(left < right && top < bottom){
            for(int i = left; i < right; i++){
                mat[top][i] = ++count;
            }
            top++;

            for(int i = top; i < bottom; i++){
                mat[i][right-1] = ++count;
            }
            right--;

            if(top<bottom)
                for(int i=right-1;i>=left;i--){
                    mat[bottom-1][i] = ++count;
                }
                bottom--;
            
            if(left<right)
                for(int i=bottom-1;i>=top;i--){
                     mat[i][left] = ++count;
                }
                left++;

        }
        return mat;

    }
}