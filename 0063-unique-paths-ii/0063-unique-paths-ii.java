class Solution {
    public int uniquePathsWithObstacles(int[][] arr) {
        int m = arr.length;
        int n = arr[0].length;
        int[][] dp = new int[m][n];
        
        if(arr[m-1][n-1]==1){
            return 0;
        }

        for(int i=m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                if(i==m-1 && j==n-1){
                    dp[m-1][n-1] = 1;
                }else if(i==m-1){
                    if(arr[i][j]!=1){
                        dp[i][j] = dp[i][j+1];
                    }
                }else if(j==n-1){
                    if(arr[i][j]!=1){
                        dp[i][j] = dp[i+1][j];
                    }
                }else{
                    if(arr[i][j]!=1){
                    dp[i][j] = dp[i+1][j] + dp[i][j+1];}
                }
            }
        }
        return dp[0][0];
    }
}