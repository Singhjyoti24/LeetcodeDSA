class Solution {
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        
        int ans = 0, ct = 0, start = 0;
        for(int i=0;i<n;i++){
            if(nums[i]==0){
                ct++;
            }
            
            if(ct<=1){
                ans = Math.max(ans, i-start);
            }
            
            while(ct>1){
                if(nums[start]==0){
                    ct--;
                }
                start++;
                if(ct<=1){
                ans = Math.max(ans, i-start);
                }
            }
        }
        
        
        return ans;
    }
}