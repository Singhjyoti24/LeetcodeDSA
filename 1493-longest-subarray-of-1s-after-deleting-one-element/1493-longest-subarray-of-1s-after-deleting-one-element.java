class Solution {
    public int longestSubarray(int[] nums) {
        int ans = 0;
        
        int ct = 0, j = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                ct++;
            }
            
            if(ct==1){
                ans = Math.max(ans, i-j);
            }else if(ct==0){
                ans = Math.max(ans, i-j);
            }
            
            while(ct>1 && j<nums.length){
                if(nums[j]==0){
                    ct--;
                }
                j++;
            }
            
            if(ct==1){
                ans = Math.max(ans, i-j);
            }else if(ct==0){
                ans = Math.max(ans, i-j);
            }
        }
        return ans;
    }
}