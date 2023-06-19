//{ Driver Code Starts
import java.util.*;
import java.lang.*;

class CountSort
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            long n = sc.nextLong();
            String arr = "";
            arr = sc.next();
            Solution obj = new Solution();
            System.out.println(obj.countSort(arr));
        }
    }
}

// } Driver Code Ends


class Solution
{
    //Function to arrange all letters of a string in lexicographical 
    //order using Counting Sort.
    public static String countSort(String arr)
    {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0;i<arr.length();i++){
            if(map.containsKey(arr.charAt(i))){
                map.put(arr.charAt(i), map.get(arr.charAt(i))+1);
            }else{
                map.put(arr.charAt(i), 1);
            }
        }
        
        char  ch = 'a';
        String ans = "";
        for(int i=0;i<=25;i++){
            if(map.containsKey(ch)){
                int h = map.get(ch);
                while(h!=0){
                    ans += ch;
                    h--;
                }
            }
            ch++;
        }
        
        return ans;
    }
}