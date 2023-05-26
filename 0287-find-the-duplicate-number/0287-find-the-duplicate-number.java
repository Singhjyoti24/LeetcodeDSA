class Solution {
    public int findDuplicate(int[] nums) {
        for(int i=0;i<nums.length;i++){
            int a = Math.abs(nums[i]);
            
            if(nums[a]<0){
                return a;
            }else{
                nums[a] = -nums[a];
            }
        }
        
        return nums.length;
    }
}