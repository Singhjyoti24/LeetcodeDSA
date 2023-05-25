class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int cnt = 0, j = 0;
        
        long pro = 1;
        for(int i=0;i<nums.length;i++){
            pro *= nums[i];
            
            if(pro<k){
                cnt += i-j+1;
            }
            
            while(pro>=k && j<nums.length){
                pro = pro/nums[j++];
                if(pro<k){
                cnt += i-j+1;
            }
            }
        }
        return cnt;
    }
}