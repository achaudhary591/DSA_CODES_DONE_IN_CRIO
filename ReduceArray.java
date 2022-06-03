import java.util.*;
/*There is an array of N elements. Perform the following operation until there are one or no elements left in the array :

Remove the largest and second largest element from the array and insert their absolute difference back in the array. */

class ReduceArray {
    // NOTE: Please do not modify this function
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int a[] = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(sc.next());
        }

        int ans = reduceArray(n, a);
        System.out.println(ans);
    }

    // TODO: Implement this method
    static int reduceArray(int n, int arr[]) {

        if (arr == null) {
            return 0;
        }

        // Priority queue can be used
        // to construct max-heap
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>(Collections.reverseOrder());

        // Insert all element of arr[]
        // into priority queue
        for (int i = 0; i < n; i++) {
            heap.offer(arr[i]);
        }

        // Perform operation until heap
        // size becomes 0 or 1
        while (heap.size() > 1) {

            // Remove largest element
            int X = heap.poll();

            // Remove 2nd largest element
            int Y = heap.poll();

            // If extracted element
            // are not equal
            if (X != Y) {
                // Find X - Y and push
                // it to heap
                int diff = Math.abs(X - Y);
                heap.offer(diff);
            }
        }

        // If heap size is 1, then
        // print the remaining element
        // Else print "-1"
        return heap.size() == 1 ? heap.poll() : 0;
    }
}