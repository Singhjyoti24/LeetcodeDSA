class Solution {
    public int findMaxForm(String[] str, int m, int n) {
        int size = str.length;
        int[] ct0 = new int[size];
        int[] ct1 = new int[size];
        
        for(int i=0;i<size;i++){
            String s = str[i];
            int c0 = 0, c1 = 0;
            for(int j=0;j<s.length();j++){
                if(s.charAt(j)=='0'){
                    c0++;
                }else{
                    c1++;
                }
            }
            
            ct0[i] = c0;
            ct1[i] = c1;
        }
        
        int[][][] dp = new int[size+1][m+1][n+1];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<=m;j++){
                for(int k=0;k<=n;k++)
                    dp[i][j][k]=-1;
            }
        }
        
        return helper(ct0, ct1, m, n, 0, dp);
    }
    
    private int helper(int[] ar1, int[] ar2, int m, int n, int i, int[][][] dp){
        if(i>=ar1.length || m<0 || n<0){
            return 0;
        }
        
        if(dp[i][m][n]!=-1){
            return dp[i][m][n];
        }
        if(ar1[i]<=m && ar2[i]<=n){
            dp[i][m][n] = Math.max(helper(ar1, ar2, m-ar1[i], n-ar2[i], i+1, dp)+1,                                                helper(ar1,ar2,m,n,i+1, dp));
        }else{
            dp[i][m][n] = helper(ar1,ar2,m,n,i+1, dp);
        }
        
        return dp[i][m][n];
    }
}