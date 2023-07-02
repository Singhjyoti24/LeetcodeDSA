class Pair{
    int ele;
    int idx;
    
    Pair(int ele, int idx){
        this.ele = ele;
        this.idx = idx;
    }
}

class Solution {
    public String[] findRelativeRanks(int[] score) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> b.ele - a.ele);
        
        for(int i=0;i<score.length;i++){
            pq.add(new Pair(score[i], i));
        }
        
        String[] ans = new String[score.length];
        int r = 1;
        while(!pq.isEmpty()){
            Pair p = pq.poll();
            if(r==1){
                ans[p.idx] = "Gold Medal";
            }else if(r==2){
                ans[p.idx] = "Silver Medal";
            }else if(r==3){
                ans[p.idx] = "Bronze Medal";
            }else{
                ans[p.idx] = Integer.toString(r);
            }
            r++;
        }
        return ans;
    }
}