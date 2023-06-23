class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int n = nums.length;
        int ct = 0;
        
        Map<Integer, Integer> map = new HashMap();
        int sum = 0;
        
        for(int i=0;i<n;i++){
            sum += nums[i];
            if(sum==goal){
                ct++;
            }
            
            if(map.containsKey(sum-goal)){
                ct += map.get(sum-goal);
            }
            map.put(sum, map.getOrDefault(sum, 0)+1);
        }
        return ct;
    }
}