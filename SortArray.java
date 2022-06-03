import java.util.*;

//Given an array of n strings, sort the array in lexicographical order.
//Lexicographical order is the order in which words appear in a dictionary.
class SortArray {
    // NOTE: Please do not modify this function
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String arr[] = new String[n];

        for (int i = 0; i < n; i++)
            arr[i] = sc.next();

        String sortedArr[] = sortArray(n, arr);

        for (String word : sortedArr)
            System.out.print(word + " ");
    }

    // TODO: Implement this method
    static String[] sortArray(int n, String[] arr) {

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i].compareTo(arr[j]) > 0) {

                    String temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }
}

/*
 * Crio Methodology
 * 
 * Milestone 1: Understand the problem clearly
 * 1. Ask questions & clarify the problem statement clearly.
 * 2. Take an example or two to confirm your understanding of the input/output &
 * extend it to test cases
 * Milestone 2: Finalize approach & execution plan
 * 1. Understand what type of problem you are solving.
 * a. Obvious logic, tests ability to convert logic to code
 * b. Figuring out logic
 * c. Knowledge of specific domain or concepts
 * d. Knowledge of specific algorithm
 * e. Mapping real world into abstract concepts/data structures
 * 2. Brainstorm multiple ways to solve the problem and pick one
 * 3. Get to a point where you can explain your approach to a 10 year old
 * 4. Take a stab at the high-level logic & write it down.
 * 5. Try to offload processing to functions & keeping your main code small.
 * Milestone 3: Code by expanding your pseudocode
 * 1. Make sure you name the variables, functions clearly.
 * 2. Avoid constants in your code unless necessary; go for generic functions,
 * you can use examples for your thinking though.
 * 3. Use libraries as much as possible
 * Milestone 4: Prove to the interviewer that your code works with unit tests
 * 1. Make sure you check boundary conditions
 * 2. Time & storage complexity
 * 3. Suggest optimizations if applicable
 */