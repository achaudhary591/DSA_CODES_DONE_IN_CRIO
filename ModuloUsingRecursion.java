import java.util.*;

public class ModuloUsingRecursion {
    // Implement your solution here
    int moduloUsingRecursion(int dividend, int divisor) {

        if (dividend < divisor) {
            return dividend;
        } else if (divisor == 0) {
            return -1;
        } else if (dividend - divisor == 0) {
            return 0;
        } else {
            return moduloUsingRecursion(dividend - divisor, divisor);
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dividend = scanner.nextInt();
        int divisor = scanner.nextInt();
        scanner.close();
        int result = new ModuloUsingRecursion().moduloUsingRecursion(dividend, divisor);
        System.out.println(result);
    }
}