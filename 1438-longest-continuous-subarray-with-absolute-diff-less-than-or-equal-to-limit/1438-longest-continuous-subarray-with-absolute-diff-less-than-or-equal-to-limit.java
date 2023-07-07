class Solution {
    public int longestSubarray(int[] nums, int limit) {
        int n = nums.length;
        int ans = 0;
        
        int start = 0;
        PriorityQueue<Integer> pq1 = new PriorityQueue<>();
        PriorityQueue<Integer> pq2 = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i=0;i<n;i++){
            pq1.add(nums[i]);
            pq2.add(nums[i]);
            
            while(pq2.peek()-pq1.peek()>limit){
                pq1.remove(nums[start]);
                pq2.remove(nums[start]);
                start++;
            }
            
            ans = Math.max(ans, i-start+1);
        }
        
        return ans;
    }
}