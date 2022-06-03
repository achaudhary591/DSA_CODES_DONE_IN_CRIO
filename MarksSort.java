/**
Problem Description
You are given a list of marks over 5 subjects scored by n students. You need to sort the student by following rules.

The student whose sum of marks will be highest must come at the top of the leaderboard.

Students whose total sum of marks are the same will be sorted alphabetically ascending by name.

In all other cases, student with lesser id will come before in the leaderboard
*/

import java.util.*;

class Student {
    int id;
    String name;
    int marks[] = new int[5];
    int total;

    public Student(int id, String name, int marks[] ) {
        this.id = id;
        this.name = name;

        for (int i = 0; i < 5; i++) {
            this.marks[i] = marks[i];

            total = total+marks[i];
        }
    }
    
}

class MarksSort {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Student arr[] = new Student[n];

        for (int i = 0; i < n; i++) {

            int id = sc.nextInt();
            String name = sc.next();
            int marks[] = new int[5];

            for (int j = 0; j < 5; j++)
                marks[j] = sc.nextInt();
            arr[i] = new Student(id, name, marks);
        }

        int res[] = marksSort(n, arr);

        for (int j : res) {
            System.out.print(j + " ");
        }
    }

    static int[] marksSort(int n, Student arr[]) {

         Arrays.sort(arr, new Comparator<Student>(){
            public int compare(Student s1, Student s2){
                if(s1.total == s2.total){
                    int diff = s1.name.compareTo(s2.name);
                    return diff == 0 ? s1.id - s2.id : diff;
                }else{
                    return s2.total - s1.total;
                }
            }
        });

        int[] res = new int[arr.length];
        for(int i=0;i<arr.length;i++){
            res[i] = arr[i].id;
        }

        return res;

    }
}