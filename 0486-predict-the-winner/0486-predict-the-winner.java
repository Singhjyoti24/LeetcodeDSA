class Solution {
    public boolean PredictTheWinner(int[] nums) {
        int n = nums.length;
        int first = helper(nums, 0, n-1, 0);
        int second = 0;
        
        for(int i=0;i<n;i++){
            second += nums[i];
        }
        second -= first;
        return first>=second;
    }
    
    private int helper(int[] nums, int left, int right, int chance){
        if(left>right){
            return 0;
        }
        
        if(chance==0){
            return Math.max(nums[left]+helper(nums, left+1,right,1), nums[right]+helper(nums,left,right-1,1));
        }else{
            return Math.min(helper(nums,left+1,right,0),helper(nums,left,right-1,0));
        }
    }
}