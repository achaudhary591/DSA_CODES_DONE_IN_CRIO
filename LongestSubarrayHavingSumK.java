/**
Problem Description
Given an array containing N integers and an integer K, Your task is to find the length of the longest subarray with the sum of the elements equal to the given value K.
*/


import java.util.*;


class LongestSubarrayHavingSumK{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n,k;
        n=sc.nextInt();
        k=sc.nextInt();
        int arr[]=new int[n];

        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        System.out.print(longestSubarrayHavingSumK(n,k,arr));
    }

    static int longestSubarrayHavingSumK(int n, int k, int arr[]){
    	
        import java.util.*;


class LongestSubarrayHavingSumK{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n,k;
        n=sc.nextInt();
        k=sc.nextInt();
        int arr[]=new int[n];

        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        System.out.print(longestSubarrayHavingSumK(n,k,arr));
    }

    static int longestSubarrayHavingSumK(int n, int k, int arr[]){

        HashMap<Integer, Integer> map = new HashMap<>();
             int sum = 0, maxLen = 0;
            
             for (int i = 0; i < n; i++) {                 
                  
                  sum += arr[i];                 
                 
                  if (sum == k)
                      maxLen = i + 1; 
                 
                  if (!map.containsKey(sum)) {
                      map.put(sum, i);
                  } 
                  
                  if (map.containsKey(sum - k)) {                       
                     
                      if (maxLen < (i - map.get(sum - k)))
                          maxLen = i - map.get(sum - k);
                  }
             }
              
              return maxLen;  
    }
}
    }
}