class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double avg = 0.00000, sum = 0.00000;
        
        for(int i=0;i<k;i++){
            sum += nums[i];
        }
        
        double max = sum/k;
        
        for(int i=k;i<nums.length;i++){
            sum += nums[i] - nums[i-k];
            max = Math.max(max, sum/k);
        }
        return max;
    }
}