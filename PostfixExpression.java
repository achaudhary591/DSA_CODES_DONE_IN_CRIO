import java.util.*;
//postfix evaluation

class PostfixExpression {
    // NOTE: Please do not modify this function
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String exp = sc.nextLine();

        int val = postfixExpression(exp);
        System.out.println(val);
    }

    // TODO: Implement this method
    static int postfixExpression(String exp) {
        LinkedList<String> expList = new LinkedList<String>();
        expList.addAll(Arrays.asList(exp.split(" ")));
        expList = operation(expList);
        return Integer.parseInt(expList.getFirst());
    }

    static LinkedList<String> operation(LinkedList<String> expList) {
        int buff1 = 0;
        int buff2 = buff1;
        int index = 0;
        for (String val : expList) {
            index++;
            if (val.equals("*") || val.equals("+") || val.equals("-")) {
                int result = 0;
                switch (val) {
                    case "*":
                        result = buff2 * buff1;
                        break;
                    case "+":
                        result = buff2 + buff1;
                        break;
                    case "-":
                        result = buff2 - buff1;
                        break;
                    case "/":
                        result = buff2 / buff1;
                        break;
                    default:
                }
                // update result at 3rd character
                expList.set(index - 1, Integer.toString(result));
                // remove 2nd character
                expList.remove(index - 2);
                // remove 1st character
                expList.remove(index - 3);
                // if size is greater than 2 else return list
                if (expList.size() > 2)
                    expList = operation(expList);
            } else {
                buff2 = buff1;
                buff1 = Integer.parseInt(val);
            }
        }
        return expList;
    }
}