class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int j = 0, max = 0;
        
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                j = i+1;
            }else{
                max = Math.max(max, i-j+1);
            }
        }
        
        return max;
    }
}