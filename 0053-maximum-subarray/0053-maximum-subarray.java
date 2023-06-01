class Solution {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE, sum = 0, min = Integer.MIN_VALUE;
        
        for(int i=0;i<nums.length;i++){
            sum += nums[i];
            
            min = Math.max(min, nums[i]);
            if(sum>0){
                max = Math.max(max, sum);
            }else{
                sum = 0;
            }
        }
        
        if(max==Integer.MIN_VALUE){
            return min;
        }
        
        return max;
    }
}