//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            String s = br.readLine().trim();
            String[] s1 = s.split(" ");
            int[] nums = new int[n];
            for(int i = 0; i < s1.length; i++)
                nums[i] = Integer.parseInt(s1[i]);
            Solution ob = new Solution();
            int ans = ob.LongestBitonicSequence(nums);
            System.out.println(ans);           
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int LongestBitonicSequence(int[] nums)
    {
        int n = nums.length;
        int[] l = new int[n];
        int[] r = new int[n];
        
        l[0] = 1;
        for(int i=1;i<n;i++){
            int max = 0;
            for(int j=i-1;j>=0;j--){
                if(nums[j]<nums[i]){
                    max = Math.max(max, l[j]);
                }
            }
            
            l[i] = max + 1;
        }
        
        r[n-1] = 1;
        for(int i=n-2;i>=0;i--){
            int max = 0;
            for(int j=i+1;j<n;j++){
                if(nums[j]<nums[i]){
                    max = Math.max(max, r[j]);
                }
            }
            
            r[i] = max + 1;
        }
        
        int max = 0;
        for(int i=0;i<n;i++){
            max = Math.max(max, l[i]+r[i]-1);
        }
        
        return max;
    }
}