class Solution {
    public int[] getAverages(int[] nums, int k) {
        int n = nums.length;
        if(k>=n){
            int[] a = new int[n];
            Arrays.fill(a, -1);
            return a;
        }else if(k==0){
            return nums;
        }
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        
        long sum = 0;
        int div = k*2 + 1;
        for(int i=0;i<k;i++){
            sum += nums[i];
        }
        
        if(2*k>=n){
            return ans;
        }
        for(int i=k;i<=2*k;i++){
            sum += nums[i];
        }
        if(k<n){
            ans[k] = (int)(sum/div);
        }
        
        int j = 0;
        for(int i=k+1;i<n;i++){
            if(i<n-k && i+k<n){
                sum -= nums[j];
                sum += nums[i+k];
                ans[i] = (int)(sum/div);
                j++;
            }else{
                ans[i] = -1;
            }
            
        }
        return ans;
    }
}