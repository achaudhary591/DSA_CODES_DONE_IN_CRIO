/**
Problem Description
Suppose you are at a party with n people (labeled from 1 to n) and among them, there may exist one celebrity. The definition of a celebrity is that all the other n - 1 people know him/her but he/she does not know any of them.

Now you want to find out who the celebrity is or verify that there is not one. Return the celebrity's label if there is a celebrity in the party. If there is no celebrity, return -1.
*/

import java.util.*;


class FindCelebrityUsingHashing{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt(),m = sc.nextInt();
        Vector<Vector<Integer> > edgeList = new Vector<Vector<Integer> >();
        for(int i =0;i<m;i++)
        {
        	edgeList.add(new Vector<Integer>());
        	edgeList.get(i).add(sc.nextInt());
        	edgeList.get(i).add(sc.nextInt());	
        }
        System.out.println(findCelebrity(n,edgeList));
    }
    private static int findCelebrity(int n,Vector<Vector<Integer> > edgeList){
        
        int[] hashArray = new int[n];
        int[] hashArray2 = new int[n];

        Arrays.fill(hashArray , 0);
        Arrays.fill(hashArray2 , 0);
        
        for(int i = 0; i < edgeList.size(); i++){
            
            if(hashArray[edgeList.get(i).get(0) - 1] > 0){
                hashArray[edgeList.get(i).get(0) - 1] = hashArray[edgeList.get(i).get(0) - 1] + 1;  
            }
            else{
                hashArray[edgeList.get(i).get(0) - 1] = 1;        
            }
        }
        
        for(int i = 0; i < edgeList.size(); i++){
            
            if(hashArray2[edgeList.get(i).get(1) - 1] > 0){
                hashArray2[edgeList.get(i).get(1) - 1] = hashArray2[edgeList.get(i).get(1) - 1] + 1;  
            }
            else{
                hashArray2[edgeList.get(i).get(1) - 1] = 1;        
            }
        }
        

        for(int i = 0; i < n; i++){
                
            if(hashArray[i] == 0 && hashArray2[i] == (n - 1)){
                return i+1;
            }
        }

        return  -1;    
    }
}