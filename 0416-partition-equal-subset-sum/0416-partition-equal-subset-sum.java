class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        int n = nums.length;
        for(int i=0;i<n;i++){
            sum += nums[i];
        }
        
        if(sum%2!=0){
            return false;
        }
        int a = sum/2;
        
        boolean[][] dp = new boolean[n+1][a+1];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[i].length;j++){
                if(i==0){
                    if(i==0 && j==0){
                        dp[i][j] = true;
                    }
                }else if(j==0){
                    dp[i][j] = true;
                }else if(nums[i-1]<=j){
                    if(dp[i-1][j]){
                        dp[i][j] = true;
                    }else{
                        dp[i][j] = dp[i-1][j-nums[i-1]]; 
                    }
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        
        return dp[n][a];
    }
}