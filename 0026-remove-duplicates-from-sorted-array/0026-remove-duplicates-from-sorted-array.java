class Solution {
    public int removeDuplicates(int[] nums) {
        int j = 0, i = 0;
        
        int n = nums.length;
        while(i<n){
            if(i+1<n && nums[i]!=nums[i+1]){
                j++;
                nums[j] = nums[i+1];
            }
            
            i++;
        }
        
        return j+1;
    }
}