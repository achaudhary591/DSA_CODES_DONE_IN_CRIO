/**
Problem Description
Hello Crio Warriors. You don't know me, but I know you and I want to play a game. Here's what happens if you lose. The question you are looking for is loaded with marks. When the timer in the back goes off, your marks will be permanently ripped off. Here is the question:


All the Bollywood superstars from the likes of Shah Rukh to Amitabh are lining up to entertain our Crio warriors. However due to certain security concerns they also brought their body doubles with them. A superstar can accompany any number of body doubles they want. Each superstar is represented by an integer, and all body doubles have the same integer representing them as the superstart.


We have to find the first superstar who came to entertain Crio warriors without a body double. If all the superstars have arrived with a body double then print -1.
*/

import java.util.*;
class FirstUniqueIntegerUsingHashMap{
	public static int firstUniqueInteger(Vector<Integer> vec)
	{        
		int len = vec.size();
		Map<Integer , Integer> map = new HashMap<>();

		for(int i = 0; i < len; i++){
			if(map.containsKey(vec.get(i))){
				map.put(vec.get(i) , map.get(vec.get(i)) + 1);
			}
			else{
				map.put(vec.get(i) , 1);
			}
		}
		for(int i = 0; i < len; i++){
			if(map.get(vec.get(i)) == 1){
				return vec.get(i);
				//break;
			}
		}			
		return -1;
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		Vector<Integer> vec=new Vector<Integer>();
		for(int i=0;i<n;i++)
			vec.add(sc.nextInt());
		System.out.println(firstUniqueInteger(vec));
	}
}