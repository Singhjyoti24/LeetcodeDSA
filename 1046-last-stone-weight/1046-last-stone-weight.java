class Solution {
    public int lastStoneWeight(int[] arr) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i=0;i<arr.length;i++){
            pq.add(arr[i]);
        }
        
        while(!pq.isEmpty()){
            if(pq.size()>=2){
                int a = pq.poll();
                int b = pq.poll();
                int diff = Math.abs(a-b);
                
                if(diff!=0){
                    pq.add(diff);
                }
            }else{
                return pq.poll();
            }
        }
        
        return 0;
    }
}