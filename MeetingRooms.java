/*Problem Description
Given a list of meeting time intervals, you have to find the minimum number of rooms required to organize all the meetings.

Input format
First line contains an integer N, indicating the number of meetings.

Next N lines contain two space separated integers S and E, indicating the Starting and Ending time of a meeting, respectively.
*/

import java.util.*;

public class MeetingRooms {

    public int findNumRooms(int[][] intervals) {

        if(intervals.length == 0){
            return 0;
        }

       
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(intervals.length , new Comparator<Integer>(){
            public int compare(Integer a , Integer b){
                return a-b;
            }
        });

         Arrays.sort(intervals , new Comparator<int[]>(){
            public int compare(final int[] a , final int[] b){
                return a[0] - b[0];
            }
        });

        minHeap.add(intervals[0][1]);

        for(int i=1; i<intervals.length; i++){
            if(intervals[i][0] >= minHeap.peek()){
                minHeap.poll();
            }
            minHeap.add(intervals[i][1]);
        }
        return minHeap.size();
    }

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int[][] nums = new int[n][2];

        for(int i = 0 ; i < n ;i++) {
            nums[i][0] = scanner.nextInt();
            nums[i][1] = scanner.nextInt();
        }

        int result = new MeetingRooms().findNumRooms(nums);

        System.out.printf("%d", result);
    }

}
