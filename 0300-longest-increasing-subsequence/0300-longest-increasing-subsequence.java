class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[n-1] = 1;
        
        int max = 1;
        for(int i=n-2;i>=0;i--){
            int a = Integer.MIN_VALUE;
            for(int j=1;j<n && i+j<n;j++){
                if(nums[i+j]>nums[i]){
                    a = Math.max(a, dp[i+j]);
                }
            }
            
            System.out.println(a);
            if(a==Integer.MIN_VALUE){
                dp[i] = 1;
            }else{
                dp[i] = a+1;
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}