class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> map = new HashSet<>();
        
        int n = nums.length;
        for(int i=0;i<n;i++){
            map.add(nums[i]);
        }
        
        int ans = 0;
        for(int i=0;i<n;i++){
            if(!map.contains(nums[i]-1)){
                int curr = nums[i];
                int streak = 1;
                
                while(map.contains(curr+1)){
                    curr += 1;
                    streak += 1;
                }
                ans = Math.max(ans, streak);
            }
        }
        return ans;
    }
}