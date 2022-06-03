import java.util.*;

class FindElement {
    // NOTE: Please do not modify this function
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];

        for (int i = 0; i < n; i++){
            arr[i] = sc.nextInt(); }

        int x = sc.nextInt();

        int result = findElement(n, arr, x);

        System.out.println("The number "+x+" is on "+result+" position");

    }

    // TODO: Implement this method
    static int findElement(int n, int[] arr, int x) {
        int pos = 0;
        for (int i=0;i<n;i++){
            if (arr[i]==x){
                pos = i;
                break;
            }
        } return pos;
    }
}