/**
Problem Description
For every index in the array, find the maximum length of the subarray (l,r) where l<=i<=r, such that a[i] is the maximum element in the subarray.

Input format
First line contains an integer N - Number of elements in the array.

Second line contains space separated N integers.
*/

import java.util.*;
import java.awt.Point;

class SubarrayElementMax{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] array = new int[size];
        for (int i = 0; i < size; ++i) {
            array[i] = sc.nextInt();
        }
        sc.close();
        int[] list_of_output = subarrayElementMax(size,array);
        for(int i=0;i<size;i++){
            System.out.print(list_of_output[i]+" ");
        }
    }

    static int[] subarrayElementMax(int size,int[] arr){

        int[] right = rightGreaterElement(arr, size);
        int[] left = leftGreaterElement(arr, size);

        int[] result = new int[size];

        for(int i =0; i < size; i++){
            int l = left[i];
            int r = right[i];
            result[i] = r - l -1;
        }
        return result;
    }

    static int[] leftGreaterElement(int[] arr, int n)
    {
        int[][] B = new int[n][2];
        for (int i = 0; i < n; i++) {
            B[i][0] = arr[i];
            B[i][1] = i;
        }
        int[] vec = new int[n];
        Arrays.fill(vec, -1);       
        Stack<Point> st = new Stack<Point>();
       
        for (int i = n - 1; i >= 0; i--) {       
            if (st.size() == 0) {
                st.push(new Point(B[i][0], B[i][1]));
            }
            else {
                while (st.size() > 0 && (st.peek()).x < B[i][0]) {
                    vec[(st.peek()).y] = B[i][1];
                    st.pop();
                }
                st.push(new Point(B[i][0], B[i][1]));
            }
        }
        while (st.size() > 0) {
            vec[(st.peek()).y] = -1;
            st.pop();
        }
        return vec;
    }

    static int[] rightGreaterElement(int[] arr, int n)
    {
        int[][] B = new int[n][2];
        for (int i = 0; i < n; i++) {
            B[i][0] = arr[i];
            B[i][1] = i;
        }
        int[] vec = new int[n];
        Arrays.fill(vec, -1);
       
        Stack<Point> st = new Stack<Point>();
        for (int i = 0; i < n; i++) {
            if (st.size() == 0) {
                st.push(new Point(B[i][0], B[i][1]));
            }
            else {
                while (st.size() > 0 && (st.peek()).x < B[i][0]) {
                    vec[(st.peek()).y] = B[i][1];
                    st.pop();
                }
                st.push(new Point(B[i][0], B[i][1]));
            }
        }
        while (st.size() > 0) {
            vec[(st.peek()).y] = n;
            st.pop();
        }
        return vec;
    }
}