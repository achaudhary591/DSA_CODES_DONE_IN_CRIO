import java.util.*;
class HelloWorld {
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        int N  = sc.nextInt();
        int[] A = new int[N];
        for(int i = 0; i < N ; i++){
            A[i] = sc.nextInt();
            
        }
        sc.close();
        System.out.println(getMinOperations(N,A));
    }
    public static int getMinOperationsForPerfectSquare(int N,int[] A){
        int[] B = distaceForPerfectSquare(N , A);
        
        int temp = 0 , count = 0;
        int i = 0;
        for(i = 0 ; i  < N - 1; i++){
            temp = Math.abs(B[i] - B[i+1]);
            if(temp == 0){
                count = B[i];
                
            }
            else{
                
                count = count + Math.abs(B[i+1] - B[i]);
                
            }
        }
        return count;
    }
    public static int[] distaceForPerfectSquare(int N ,int[] A){
        int[] B = new int[N];
        for(int i = 0; i < N ; i++){
            double temp = Math.sqrt(A[i]);
            if(temp - Math.floor(temp) == 0){
                B[i] = 0;
            }
            else{
                double temp2 = Math.floor(temp) + 1;
                B[i] = (int)(temp2 * temp2) - A[i];
            }
            //System.out.println("B -"+B[i]);
        }
        return B;
    }
}