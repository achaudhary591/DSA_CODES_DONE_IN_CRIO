import java.util.*;

class SeriesSumOfInfiniteGP {
    // NOTE: Please do not modify this function
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        double A = sc.nextDouble();
        double R = sc.nextDouble();

        double result = seriesSumII(A, R);

        System.out.println(result);
        sc.close();
    }

    // TODO: Implement this method
    static double seriesSumII(double A, double R) {

        double sum;

        if (R < 1) {
            sum = A / (1 - R);
        } else {
            sum = A / (R - 1);
        }
        return sum;

    }
}