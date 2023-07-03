class Solution {
    public int furthestBuilding(int[] arr, int bricks, int ladders) {
        int n = arr.length;
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        
        for(int i=0;i<n-1;i++){
            int diff = arr[i+1]-arr[i];
            
            if(diff>0){
                pq.add(diff);
            }
            
            if(pq.size()>ladders){
                bricks -= pq.poll();
            }
            
            if(bricks<0){
                return i;
            }
        }
        
        return n-1;
    }
}