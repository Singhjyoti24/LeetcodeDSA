class Solution {
    public long minCost(int[] nums, int[] cost) {
        int low = Integer.MAX_VALUE, high = Integer.MIN_VALUE;
        for(int num: nums){
            low = Math.min(low, num);
            high = Math.max(high, num);
        }
        long ans = getCost(nums, cost, nums[0]);
        
        while(low<high){
            int mid = (low+high)/2;
            long c1 = getCost(nums, cost, mid);
            long c2 = getCost(nums, cost, mid+1);
            
            ans = Math.min(c1, c2);
            if(c1>c2){
                low = mid+1;
            }else{
                high = mid;
            }
        }
        
        return ans;
    }
    
    private long getCost(int[] nums, int[] cost, int base) {
        long result = 0L;
        for (int i = 0; i < nums.length; ++i)
            result += 1L * Math.abs(nums[i] - base) * cost[i];
        return result;
    }
}