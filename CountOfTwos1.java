/*Write a program that counts the number of occurrences of 2 as a digit in numbers from 0 to n*/

import java.util.*;

public class CountOfTwos {
    int countOfTwos(int n) {

        int count = 0;
        for (int i = 2; i <= n; i++)
            count += number0f2s(i);

        return count;
    }

    static int number0f2s(int n) {
        int count = 0;
        while (n > 0) {
            if (n % 10 == 2)
                count++;

            n = n / 10;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int result = new CountOfTwos().countOfTwos(n);
        System.out.println(result);
        scanner.close();
    }
}