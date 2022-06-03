import java.util.*;

class PascalTriangleDebug {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        List<List<Integer>> result = pascalTriangle(n);

        for (List<Integer> row : result) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    static List<List<Integer>> pascalTriangle(int A) {

        List<List<Integer>> R = new ArrayList<List<Integer>>();

        for (int i = 0; i < A; i++) {
            R.add(new ArrayList<>());
        }
        if (A >= 1) {
            R.get(0).add(1);
        }
        if (A > 1) {
            for (int i = 1; i < A; i++) {
                int length = R.get(i - 1).size();
                R.get(i).add(1);
                for (int j = 1; j < length; j++) {
                    R.get(i).add(R.get(i - 1).get(j) + R.get(i - 1).get(j - 1));
                }
                R.get(i).add(1);
            }
        }
        return R;
    }
}