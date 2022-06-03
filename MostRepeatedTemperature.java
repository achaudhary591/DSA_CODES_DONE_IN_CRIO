import java.util.*;

//most repeated temeprature
class MostRepeatedTemperature {
    // NOTE: Please do not modify this function
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int a[] = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(sc.next());
        }

        int ans = mostRepeatedTemperature(n, a);
        System.out.println(ans);
    }

    // TODO: Implement this method
    static int mostRepeatedTemperature(int n, int a[]) {

        HashMap<Integer, Integer> setTemp = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (a[i] == a[j]) {
                    count++;
                }
                setTemp.put(a[i], count);
            }

        }
        int tempMaxCount = 0;
        int tempMax = 0;
        for (int i = 0; i < n; i++) {
            int count = setTemp.get(a[i]);
            if (tempMaxCount < count) {
                tempMaxCount = count;
                tempMax = a[i];
            } else if (tempMaxCount == count) {
                if (tempMax < a[i]) {
                    tempMax = a[i];
                }
            }
        }
        return tempMax;
    }
}