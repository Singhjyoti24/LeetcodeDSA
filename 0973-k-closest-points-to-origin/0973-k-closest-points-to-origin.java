class Pair{
    int dis;
    int x;
    int y;
    Pair(int dis, int x, int y){
        this.dis = dis;
        this.x = x;
        this.y = y;
    }
}

class Solution {
    public int[][] kClosest(int[][] mat, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b)->b.dis-a.dis);
        
        for(int i=0;i<mat.length;i++){
            int x = mat[i][0];
            int y = mat[i][1];
            
            int dis = x*x + y*y;
            pq.add(new Pair(dis, x, y));
            if(pq.size()>k){
                pq.poll();
            }
        }
        
        int[][] ans = new int[k][2];
        for(int i=0;i<k;i++){
            Pair p = pq.poll();
            ans[i][0] = p.x;
            ans[i][1] = p.y;
        }
        return ans;
    }
}