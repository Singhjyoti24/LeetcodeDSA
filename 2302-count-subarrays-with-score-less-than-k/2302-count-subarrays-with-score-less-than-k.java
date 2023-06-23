class Solution {
    public long countSubarrays(int[] nums, long k) {
        int n = nums.length;
        
        long ct = 0;
        int j = 0; long sum = 0;
        for(int i=0;i<n;i++){
            sum += nums[i];
            
            if(sum * (i-j+1)<k){
                ct += i-j+1;
            }
            
            while(sum * (i-j+1)>=k){
                sum -= nums[j];
                j++;
                if(sum * (i-j+1)<k){
                     ct += i-j+1;
                }
            }
        }
        
        return ct;
    }
}