
/*A child is running up a staircase with N steps. The child can hop either 1 step, 2 steps or 3 steps at a time. Can you write a program to count the number of possible ways in which the child can run up the staircase. */
import java.util.*;

class TripleStep {
    private static final int M = 1_000_000_007;

    // The set of equations for S[k+m], S[k+m-1], S[k+m-2]
    // a[t] is S[k-t] and b[t] is S[m-t]
    private static long[] mul(long[] a, long[] b) {
        long r0110 = a[0]*b[1] + a[1]*b[0];
        long r0011 = a[0]*b[0] + a[1]*b[1];
        return new long[] {
            (a[0]*b[2] + a[2]*b[0] + r0110 + r0011) % M,
            (a[1]*b[2] + a[2]*b[1] + r0011) % M,
            (r0110 + a[2]*b[2] - a[1]*b[1]) % M
        };
    }

    public static long numberOfWays(int n) {
        long[] result = {1, 0, 0};
        long[] square = {1, 0, 0};
        // Exponentiation by squaring
        for (int i = n; i != 0; i /= 2) {
            if (i % 2 == 1) result = mul(result, square);
            square = mul(square, square);
        }
        return result[0];
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        TripleStep tripleStep = new TripleStep();
        long result = tripleStep.numberOfWays(n);
        System.out.println(result);
        scanner.close();
    }
}