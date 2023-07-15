class Solution {
    public int maxValue(int[][] arr, int k) {
        int n = arr.length;
        if(k==0 || n==0){
            return 0;
        }else if(n==1 && k>=1){
            return arr[0][2];
        }
        Arrays.sort(arr, (a,b)-> a[0]-b[0]);
        
        int[][] dp = new int[k+1][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        
        return helper(arr, k, -1, 0, 0, dp);
    }
    
    public int helper(int[][] arr, int k, int start, int i, int ct, int[][] dp){
        if(i==arr.length || ct==k){
            return 0;
        }
        
        if(arr[i][0]<=start){
            return helper(arr, k, start, i+1, ct, dp);
        }
        
        if(dp[ct][i]!=-1){
            return dp[ct][i];
        }
        
        dp[ct][i] = Math.max(arr[i][2]+helper(arr, k, arr[i][1], i+1, ct+1, dp), helper(arr, k, start, i+1, ct, dp));
        return dp[ct][i];
    }
}