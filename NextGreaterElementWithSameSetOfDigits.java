/**
Problem Description
Given a positive integer n, find the smallest integer which has exactly the same digits existing in the integer n and is greater in value than n. If no such positive integer exists, return -1.
*/

import java.util.*;

class NextGreaterElementWithSameSetOfDigits{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n;
        n=sc.nextInt();
        System.out.print(nextGreaterElementWithSameSetOfDigits(n));
    }

    static int nextGreaterElementWithSameSetOfDigits(int n){
        
        char[] number = convertNumberToArray(n);
        int i=0 , j=0;

        for(i = number.length - 1; i > 0; i--){
            if(number[i] > number[i-1]){
                break;
            }
        }

        if(i == 0){
            return -1;
        }
        else{

            int x = number[i-1] , min = i;

            for(j = i+1; j < number.length; j++){
                if(number[j] > x && number[j] < number[min]){
                    min = j;
                }
            }

            swap(number , i - 1, min);
            Arrays.sort(number , i ,number.length);
             
            int result = Integer.parseInt(new String(number));

            return result;
        }
    }

    static char[] convertNumberToArray(int n){

        String str = Integer.toString(n);
        char[] num = new char[str.length()];

        for(int i = 0; i < str.length(); i++){
            num[i] = str.charAt(i) ;
        }

        return num;
    }


    static void swap(char[] number, int i, int j)
    {
        char temp  = number[i];
        number[i] = number[j];
        number[j] = temp;
    }     
    
}