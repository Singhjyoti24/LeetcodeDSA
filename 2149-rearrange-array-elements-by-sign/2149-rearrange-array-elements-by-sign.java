class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        
        Queue<Integer> p = new LinkedList<>();
        Queue<Integer> ne = new LinkedList<>();
        
        for(int i=0;i<n;i++){
            if(nums[i]>=0){
                p.add(nums[i]);
            }else{
                ne.add(nums[i]);
            }
        }
        
        int j = 0;
        while(j<n){
            if(!p.isEmpty()){
                nums[j] = p.poll();
                j++;
            }
            
            if(!ne.isEmpty()){
                nums[j] = ne.poll();
                j++;
            }
        }
        
        return nums;
    }
}