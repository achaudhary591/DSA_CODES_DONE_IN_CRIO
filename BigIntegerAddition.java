import java.util.*;

class BigIntegerAddition {
    // NOTE: Please do not modify this function
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String num1 = sc.next();
        String num2 = sc.next();

        String ans = bigIntegerAddition(num1, num2);
        System.out.println(ans);

    }

    static int digitsAt(String num, int positionFromLSB) {

        if (positionFromLSB > num.length() - 1) {

            return 0;
        }

        return num.charAt(num.length() - positionFromLSB - 1) - '0';

    }

    static void buildDigits(StringBuilder reversedNumber, int digit) {

        reversedNumber.append(digit);
    }

    // TODO: Implement this method
    static String bigIntegerAddition(String num1, String num2) {

        int carry = 0;
        StringBuilder reversedSum = new StringBuilder();

        for (int i = 0; i < num1.length() || i < num2.length(); i++) {
            int sumOfDigits = digitsAt(num1, i) + digitsAt(num2, i) + carry;

            buildDigits(reversedSum, sumOfDigits % 10);
            carry = sumOfDigits / 10;
        }

        if (carry != 0) {
            buildDigits(reversedSum, carry);
        }

        return reversedSum.reverse().toString();
    }

}