/**
Problem Description
Given an array A, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
*/

import java.util.*;
class MoveZeroes{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		Vector<Integer> vec = new Vector<Integer>();
		for(int i=0;i<n;i++)
			vec.add(sc.nextInt());
		Vector<Integer> res = moveZeroes(vec);
		for(Integer elem : res)
			System.out.print(elem+" ");
	}
	private static Vector<Integer> moveZeroes(Vector<Integer> vec){

		int count = 0;

		for(int i = 0; i < vec.size(); i++){
			if(vec.get(i) != 0){
				vec.set(count++ , vec.get(i));
			}
		}

		while(count < vec.size()){
			vec.set(count++ , 0);
		}
		return vec ;
	}
}