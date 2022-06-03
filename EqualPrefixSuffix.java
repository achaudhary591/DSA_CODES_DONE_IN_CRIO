/**
 Problem Description
A proper prefix sum array is a prefix sum array without the entire array sum, that is, with the last element of a normal prefix sum array missing. Thus, for a = [1, 2, 3, 4], the proper prefix sum array, pps = [1, 3, 6].

Similarly, a proper suffix sum array is a suffix sum array without the entire array sum, that is, with the first element of a normal suffix sum array missing. For the above example, the proper suffix sum array, pss = [9, 7, 4].

A magic sum is a non negative sum that’ll exist in both the pps and the pss.

Given an array of size n, you have to find the largest magic sum, that is, the largest non negative element that exists in both the pps and the pss. If no such element exists, return -1.

Note:- A proper prefix and proper suffix of an array is not equal to the array itself and non - empty.
 */



import java.util.*;

class EqualPrefixSuffix {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int arr[] = new int[n];

        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        long res = equalPrefixSuffix(n, arr);

        System.out.println(res);
    }

    static long equalPrefixSuffix(int n, int arr[]) {

        long[] properPrefixArray = new long[n - 1];
        long[] properSuffixArray = new long[n - 1];

       
        properPrefixArray[0] = arr[0];
        properSuffixArray[n - 2] = arr[n - 1];
                
        for(int i = 1; i < n - 1 ; i++){            
            properPrefixArray[i] = properPrefixArray[i - 1] + arr[i];            
        }

         for(int i = n - 3; i >= 0 ; i--){
            properSuffixArray[i] = properSuffixArray[i + 1] + arr[i + 1];           
        }

        // System.out.println("prefix array ................");
        // for(int i = 0; i < properPrefixArray.length; i++){
        //     System.out.print(" "+properPrefixArray[i]);
        // }
        // System.out.println("");
        // System.out.println("suffix array ................");
        // for(int i = 0; i < properSuffixArray.length; i++){
        //     System.out.print(" "+properSuffixArray[i]);
        // }
        // System.out.println("");

        long result = maxAmongArrays(properPrefixArray , properSuffixArray);
        return result;
    }

    static long maxAmongArrays(long[] properPrefixArray , long[] properSuffixArray){

        Set<Long> firstArray = new HashSet<>();

         PriorityQueue<Long> maxHeap = new PriorityQueue<Long>(Collections.reverseOrder());

        for(long nums : properPrefixArray){
            firstArray.add(nums);
        }  

        long currentMax = (long)Double.NEGATIVE_INFINITY;  
        
        for(Long n : properSuffixArray){  
            if(firstArray.contains(n)){  
                if(currentMax < n){  
                    currentMax = n;
                    maxHeap.add(n);  
                }                
            }            
        } 
        if(maxHeap.peek() == null){
            return -1;
        }       
        else{
            if(maxHeap.peek() > 0)
                return maxHeap.peek();
            else
                return -1;
        }
    }
}