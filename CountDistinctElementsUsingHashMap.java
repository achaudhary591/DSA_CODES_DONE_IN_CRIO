/**
Problem Description
Given an array of N elements and an integer B, you have to find the count of distinct numbers in all windows of size B.

You have to return an array of size N-B+1 where i'th element in the array is the number of distinct elements in sequence Ai, Ai+1 ,..., Ai+B-1. If B > N, return an empty array.
*/

import java.util.*;

class CountDistinctElementsUsingHashMap {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int b = sc.nextInt();

        int arr[] = new int[n];

        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        ArrayList<Integer> res = countDistinctElements(n, b, arr);

        for (int j : res)
            System.out.print(j + " ");

    }

    static ArrayList<Integer> countDistinctElements(int N, int B, int arr[]) {

        ArrayList<Integer> result = new ArrayList<>();
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();

        if(B > N)
            return result;
        
        for(int i = 0; i < B; i++)
            hashMap.put(arr[i] , hashMap.getOrDefault(arr[i] , 0) + 1);

        result.add(hashMap.size());

        for(int i = B; i < arr.length; i++){

            if(hashMap.get(arr[i - B]) == 1){
                hashMap.remove(arr[i - B]);
            }
            else{
                hashMap.put(arr[i - B] , hashMap.get(arr[i - B]) - 1);
            }
            hashMap.put(arr[i], hashMap.getOrDefault(arr[i], 0) + 1);
            result.add(hashMap.size());
        }
        return result;
    }
}