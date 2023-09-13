//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int arr[] = new int[N];
            for(int i = 0;i < N;i++)
                arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            int x = ob.equalPartition(N, arr);
            if(x == 1)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution{
    static int[][] dp;

    static int equalPartition(int N, int arr[]) {
        int sumi = 0;
        for (int i = 0; i < arr.length; i++) {
            sumi += arr[i];
        }
        if (sumi % 2 != 0) {
            return 0;
        }

        int sum = sumi / 2;
        dp = new int[N + 1][sum + 1];

        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        return subsetHelper(N, arr, sum, dp);
    }

    public static int subsetHelper(int N, int arr[], int sum, int[][] dp) {
        if (N == 0 && sum != 0) {
            return 0;
        } else if (N == 0 && sum == 0) {
            return 1;
        } else if (sum == 0) {
            return 1;
        }

        if (dp[N][sum] != -1) {
            return dp[N][sum];
        }

        if (arr[N - 1] <= sum) {
            int a1 = subsetHelper(N - 1, arr, sum - arr[N - 1], dp);
            int a2 = subsetHelper(N - 1, arr, sum, dp);
            if (a1 == 1 || a2 == 1) {
                dp[N][sum] = 1;
            } else {
                dp[N][sum] = 0;
            }
        } else {
            dp[N][sum] = subsetHelper(N - 1, arr, sum, dp);
        }

        return dp[N][sum];
    }
}