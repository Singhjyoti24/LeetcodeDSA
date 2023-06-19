class Solution {
    public long mostPoints(int[][] q) {
        long[] dp = new long[q.length];
        return helper(q, 0, q.length, dp);
    }
    
    public long helper(int[][] arr, int i, int n, long[] dp){
        if(n<=0){
            return 0;
        }
        
        if(dp[i]!=0){
            return dp[i];
        }
        
        dp[i] = Math.max(helper(arr, i+arr[i][1]+1, n-arr[i][1]-1, dp)+arr[i][0], helper(arr, i+1,           n-1, dp));
        return dp[i];
    }
}