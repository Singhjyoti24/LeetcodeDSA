class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        int n = costs.length;
        PriorityQueue<Integer> hpq = new PriorityQueue<>();
        PriorityQueue<Integer> tpq = new PriorityQueue<>();

        for (int i = 0; i < candidates; i++) {
            hpq.add(costs[i]);
        }
        for (int i = Math.max(candidates, n - candidates); i < costs.length; i++) {
            tpq.add(costs[i]);
        }
        
        long ans = 0;
        int nextHead = candidates;
        int nextTail = n - candidates - 1;
        
        for(int i=0;i<k;i++){
            if(tpq.isEmpty() || !hpq.isEmpty() && hpq.peek() <= tpq.peek()){
                ans += hpq.poll();
                if(nextHead <= nextTail){
                hpq.add(costs[nextHead]);
                nextHead++;
                }
            }else{
                ans += tpq.poll();
                if(nextHead <= nextTail){
                tpq.add(costs[nextTail]);
                nextTail--;
                }
            }
            
            
        }
        
        return ans;
    }
}