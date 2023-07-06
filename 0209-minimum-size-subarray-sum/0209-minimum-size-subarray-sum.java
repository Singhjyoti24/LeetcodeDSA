class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int min = Integer.MAX_VALUE;
        
        int j = 0, sum = 0;
        for(int i=0;i<nums.length;i++){
            sum += nums[i];
            
            
            while(sum>=target){
                if(sum>=target){
                min = Math.min(min, i-j+1);
                }
                sum -= nums[j++];
            }
        }
        
        if(min==Integer.MAX_VALUE){
            return 0;
        }
        return min;
    }
}