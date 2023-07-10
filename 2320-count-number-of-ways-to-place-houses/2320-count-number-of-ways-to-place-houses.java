class Solution {
    public int countHousePlacements(int n) {
        int a = 1, b = 1, c = 2, mod = (int)1e9 + 7;
        for (int i = 0; i < n; ++i) {
            c = (a + b) % mod;
            a = b;
            b = c;
        }
        return (int)(1L * b * b % mod);
//         long[][] dp = new long[2][n+1];
//         for(int i=0;i<2;i++){
//             for(int j=0;j<=n;j++){
//                 dp[i][j] = -1;
//             }
//         }
        
        // long ans = helper(n, 0, dp)%mod;
        // return (int)(ans * ans)%mod;
    }
    
//     public long helper(int n, int inc, long[][] dp){
//         if(n==0){
//             return 1;
//         }
        
//         if(dp[inc][n]!=-1){
//             return dp[inc][n]%mod;
//         }
//         if(inc==0){
//             return dp[inc][n] = helper(n-1, 1, dp)%mod + helper(n-1, 0, dp)%mod;
//         }else{
//             return dp[inc][n] = helper(n-1, 0, dp)%mod;
//         }
//     }
}