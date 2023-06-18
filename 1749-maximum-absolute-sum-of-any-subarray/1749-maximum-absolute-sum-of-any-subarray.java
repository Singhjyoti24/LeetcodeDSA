class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int max = Integer.MIN_VALUE;
        int n = nums.length;
        
        int sum = 0;
        for(int i=0;i<n;i++){
            sum += nums[i];
            max = Math.max(max, sum);
            
            if(sum<0){
                sum = 0;
            }
        }
        
        sum = 0;
        int min = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            sum += nums[i];
            min = Math.min(min, sum);
            
            if(sum>0){
                sum = 0;
            }
        }
        
        return Math.max(Math.abs(max),Math.abs(min));
    }
    
}