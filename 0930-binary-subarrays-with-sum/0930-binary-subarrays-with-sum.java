class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int n = nums.length;
        int[] pre = new int[n+1];
        for(int i=0;i<n;i++){
            pre[i+1] = pre[i] + nums[i];
        }
        
        Map<Integer, Integer> map = new HashMap();
        int ans = 0;
        
        for(int a : pre){
            ans += map.getOrDefault(a, 0);
            map.put(a+goal, map.getOrDefault(a+goal,0)+1);
        }
        return ans;
    }
}