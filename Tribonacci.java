import java.util.*;

class Tribonacci {
    // Implement Your Solution here
    int tribonacci(int n) {

        ArrayList<Integer> result = new ArrayList<Integer>();

        result.add(0, 0);
        result.add(1, 1);
        result.add(2, 1);

        int sum = 0;

        for (int i = 3; i <= n; i++) {
            sum = result.get(i - 1) + result.get(i - 2) + result.get(i - 3);
            result.add(i, sum);
        }

        return result.get(n);

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();
        int result = new Tribonacci().tribonacci(n);
        System.out.println(result);
    }
}