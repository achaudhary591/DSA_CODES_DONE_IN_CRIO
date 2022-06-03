/**
Problem Description
Given an array arr of size N and an integer K, print the count of distinct pairs in the array whose difference is equal to K. Note: The array contains distinct integers.
*/

import java.util.*;


class UniqueDiffPairUsingHashMap{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        List<Integer> arr = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            arr.add(i, sc.nextInt());
        }
        int result = uniqueDiffPair(n, k, arr);
        System.out.println(result);
        sc.close();
    }

    static int uniqueDiffPair(int n, int k, List<Integer> arr){

        Map<Integer , Integer> map = new HashMap<Integer , Integer>();
        int count = 0;
        
        for(int i = 0; i < n; i++){
            if(map.get(arr.get(i)) != null)
                map.put(arr.get(i) , map.get(arr.get(i)) + 1);            
            else
                map.put(arr.get(i) , 1);
        }

        if(k == 0){
            for(Map.Entry<Integer, Integer> it : map.entrySet()){
                if(it.getValue() > 1)
                    count++;
            }
        }
        else{
            for(Map.Entry<Integer, Integer> it : map.entrySet()){
                if (map.get(it.getKey() + k) != null){
                    count++;
                }
            }
        }
        return count;
    }
}