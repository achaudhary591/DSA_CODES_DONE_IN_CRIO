import java.util.*;
import java.lang.*;

class LargestFibonacciNumber{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-->0) {
            int n = sc.nextInt();
            int result = largestFibonacciNumber(n);
            System.out.println(result);
        }
        sc.close();
    }

    static int largestFibonacciNumber(int n){
        int n1=0 , n2=1;
        int n3 = n1+n2;
        while(n3<=n){
            n1 = n2;
            n2 = n3;
            n3 = n1+n2;
        }
            int sum1;
       
            int sum = (Math.abs(n3 - n) >=
               Math.abs(n2 - n)) ?
               n2 : n3;
            if (n == sum){
                sum1 = n2;
            }
            else {
                sum1 = sum;
            }

        return sum1;
    }
}
