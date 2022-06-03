/**
Problem Description
Given a n x n matrix where each of the rows and columns are sorted in ascending order, find the kth smallest element in the matrix.

Note that it is the kth smallest element in the sorted order, not the kth distinct element.
*/

import java.util.*;


class KthSmallestElementInMatrix{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        List<ArrayList<Integer>>Matrix = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < n; i++) {
            ArrayList<Integer>row = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                row.add(sc.nextInt());
            }
            Matrix.add(row);
        }
        int ans = kthSmallestElementInMatrix(Matrix,k);
        System.out.print(ans);
    }

    static int kthSmallestElementInMatrix(List<ArrayList<Integer>>Matrix, int k){

        int low = Matrix.get(0).get(0);
        int high = Matrix.get(Matrix.size() - 1).get(Matrix.get(0).size() - 1) + 1;

        while(low < high){
            final int mid = low + (high - low) / 2;
            int count = 0;
            int col = Matrix.get(0).size() - 1;

            for(int row = 0; row < Matrix.size(); ++row){
                while(col >= 0 && Matrix.get(row).get(col) > mid){
                    col--;
                }

                count += (col + 1);
            }
            if(count  < k)
                low = mid+1;
            else
                high = mid;
        }
        return low;
    }   
    
}