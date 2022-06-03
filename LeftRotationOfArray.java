import java.util.*;

class LeftRotationOfArray {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int d = sc.nextInt();

        d %= n;
        int[] a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();

        int[] result = leftRotation(a, d);

        for (int j : result)
            System.out.print(j + " ");

    }

    static int[] leftRotation(int[] a, int d) {

        int n = a.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int new_pos = (i - d + n) % n;
            ans[new_pos] = a[i];
        }
        return ans;
    }
}