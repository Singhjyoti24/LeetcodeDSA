//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().trim().split(" ");
            int[] array = new int[n - 1];
            for (int i = 0; i < n - 1; i++) {
                array[i] = Integer.parseInt(str[i]);
            }
            Solution sln = new Solution();
            System.out.println(sln.missingNumber(array, n));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    int missingNumber(int arr[], int n) {
        int ct = 0;
        for(int i=0;i<arr.length;i++){
            int a = Math.abs(arr[i]);
            
            if(a<arr.length){
                arr[a] = 0-arr[a];
            }
            if(a==n){
                ct++;
            }
        }
        
        if(ct==0){
            return n;
        }
        
        for(int i=0;i<arr.length;i++){
            if(i!=0 && arr[i]>0){
                return i;
            }
        }
        
        return arr.length;
    }
}