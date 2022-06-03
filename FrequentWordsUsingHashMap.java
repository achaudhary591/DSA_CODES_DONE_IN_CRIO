/**
Problem Description
You are given a list of words present in a book. Your younger brother is really curious to know the K most frequent words in the book, you have to find them.


Your answer should be sorted by frequency from highest to lowest. If two words have the same frequency, then the word with the lower alphabetical order should come first.
*/

import java.util.*;

class FrequentWordsUsingHashMap{
	public static Vector<String> frequentWords(Vector<String> vec,int k)
	{
		HashMap<String , Integer> map = new HashMap<>();			

		for(String subString : vec){
			map.put(subString , map.getOrDefault(subString , 0) + 1);
		}
		Vector<String> frequent = new Vector<String>(map.keySet());
		Collections.sort(frequent, (w1, w2) -> map.get(w1).equals(map.get(w2))?
                w1.compareTo(w2) : map.get(w2) - map.get(w1));
		
		Vector<String> newVec = new Vector<String>();
		for(int i = 0; i < k; i++){
			newVec.add(frequent.get(i));
		}
		return newVec;
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		Vector<String> vec=new Vector<String>();
		for(int i=0;i<n;i++)
			vec.add(sc.next());
		int k=sc.nextInt();
		Vector<String> ans = frequentWords(vec, k);
		for(int i=0;i<k;i++)
			System.out.println(ans.get(i));
	}
}