//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class gfg
{
    public static void main(String args[])throws IOException
    {
        //reading input using BufferedReader class
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        
        //reading total testcases
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            //reading number of elements and weight
            int n = Integer.parseInt(read.readLine());
            int w = Integer.parseInt(read.readLine());
            
            int val[] = new int[n];
            int wt[] = new int[n];
            
            String st[] = read.readLine().trim().split("\\s+");
            
            //inserting the values
            for(int i = 0; i < n; i++)
              val[i] = Integer.parseInt(st[i]);
             
            String s[] = read.readLine().trim().split("\\s+"); 
            
            //inserting the weigths
            for(int i = 0; i < n; i++)
              wt[i] = Integer.parseInt(s[i]);
              
            //calling method knapSack() of class Knapsack
            System.out.println(new Solution().knapSack(w, wt, val, n));
        }
    }
}




// } Driver Code Ends


class Solution 
{ 
    //Function to return max value that can be put in knapsack of capacity W.
    static int[][] dp;

    static int knapSack(int W, int[] wt, int[] val, int n) {
        // Initialize the memoization table with -1 values
        dp = new int[n + 1][W + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], -1);
        }

        // Call the recursive helper function
        return knapSackHelper(W, wt, val, n);
    }

    static int knapSackHelper(int W, int[] wt, int[] val, int n) {
        // Base case: If either the capacity or the number of items is 0, the value is 0
        if (W == 0 || n == 0) {
            return 0;
        }

        // If the result is already computed, return it
        if (dp[n][W] != -1) {
            return dp[n][W];
        }

        // If the weight of the current item is more than the remaining capacity,
        // it cannot be included in the knapsack
        if (wt[n - 1] > W) {
            dp[n][W] = knapSackHelper(W, wt, val, n - 1);
        } else {
            // Otherwise, consider two options: include the item or exclude it
            int include = val[n - 1] + knapSackHelper(W - wt[n - 1], wt, val, n - 1);
            int exclude = knapSackHelper(W, wt, val, n - 1);
            dp[n][W] = Math.max(include, exclude);
        }

        return dp[n][W];
    }

}


