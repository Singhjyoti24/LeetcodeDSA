class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        long ans = 0;
        int j = -1;
        int min = -1, max = -1;
        
        for(int i=0;i<nums.length;i++){
            if (nums[i] < minK || nums[i] > maxK)
                j = i;
            
            if (nums[i] == minK)
                min = i;
            if (nums[i] == maxK)
                max = i;

            ans += Math.max(0, Math.min(max, min) - j);
        }
        return ans;
    }
}