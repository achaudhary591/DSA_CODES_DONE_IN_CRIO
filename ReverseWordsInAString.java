/*Problem Description
A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.

Return a string of the words in reverse order concatenated by a single space.

Note that s may contain leading or trailing spaces or multiple spaces between two words.

The returned string should only have a single space separating the words.

Do not include any extra spaces.*/

import java.util.*;


class ReverseWordsInAString{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(reverseWordsInAString(s));
        sc.close();
    }

    static String reverseWordsInAString(String s){

       String result = new String();
    int i = 0;
    int n = s.length();

    while(i < n){
        while(i < n && s.charAt(i) == ' ') i++;
        if(i >= n) break;
        int j = i + 1;
        while(j < n && s.charAt(j) != ' ') j++;
        String sub = s.substring(i, j);
        if(result.length() == 0) result = sub;
        else result = sub + " " + result;
        i = j+1;
        
    }
    return result;
    }
}ObjectMapper om = new ObjectMapper();
Trade[] trades = om.readValue(inputFile , Trade[].class);
System.out.println("We have deserialize it");

for(Trade trade:trades){
  System.out.println(trade);
}
om.writeValue(outputFile, trades);
System.out.println("Serialization done!");