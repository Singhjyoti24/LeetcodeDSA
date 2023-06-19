class Solution {
    public int minDistance(String a, String b) {
        int m = a.length();
        int n = b.length();
        
        int[][] dp = new int[m+1][n+1];
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[i].length;j++){
                dp[i][j] = -1;
            }
        }
        
        int len = helper(a, b, m, n, dp);
        return m-len+n-len;
    }
    
    public int helper(String a,String b, int m, int n, int[][] dp){
        if(m==0 || n==0){
            return 0;
        }
        
        if(dp[m][n]!=-1){
            return dp[m][n];
        }
        
        if(a.charAt(m-1)==b.charAt(n-1)){
            dp[m][n] = helper(a, b, m-1, n-1, dp)+1;
            return dp[m][n];
        }else{
            dp[m][n] = Math.max(helper(a, b, m-1, n, dp), helper(a, b, m, n-1, dp));
            return dp[m][n];
        }
    }
}