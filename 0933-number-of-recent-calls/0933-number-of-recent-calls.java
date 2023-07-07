class RecentCounter {

    PriorityQueue<Integer> pq = new PriorityQueue<>();
    public RecentCounter() {
        
    }
    
    public int ping(int t) {
        pq.add(t);
        
        int min = t - 3000;
        int max = t;
        
        while(pq.peek()<min){
            pq.poll();
        }
        
        return pq.size();
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */