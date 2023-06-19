//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            String S = br.readLine().trim();
            Solution obj = new Solution();
            List<String> ans = obj.find_permutation(S);
            for( int i = 0; i < ans.size(); i++)
            {
                out.print(ans.get(i)+" ");
            }
            out.println();
                        
        }
        out.close();
	}
}


// } Driver Code Ends


class Solution {
    public List<String> find_permutation(String S) {
        List<String> arr = new ArrayList<String>();
        helper(S, "", arr);
        Collections.sort(arr);
        return arr;
    }
    
    public void helper(String s, String ans, List<String> arr){
        if(s.length()==0){
            if(!arr.contains(ans)){
                arr.add(ans);
            }
            
            return;
        }
        
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            String ros = s.substring(0,i)+s.substring(i+1);
            
            helper(ros, ans+ch, arr);
        }
    }
	   
}