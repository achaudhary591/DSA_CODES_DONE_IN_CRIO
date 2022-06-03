import java.util.*;

class PyramidPrinting {
    // NOTE: Please do not modify this function
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        String[] pattern = pyramidPrinting(n);

        for (int i = 0; i < n; i++)
            System.out.println(pattern[i]);

    }


    public static String getStars(int i){

        StringBuilder starB = new StringBuilder();
        for (int j =0;j<i;j++){
            if (j!=0){
                starB.append(" ");
            }
            starB.append("*");

        } return starB.toString();

    }

    // TODO: Implement this method
    static String[] pyramidPrinting(int n) {
             
      
       String[] a = new String[n]; 
       for (int i=0;i<n;i++){
           a[i] = getStars(i+1);
       }return a;
            
    }
}