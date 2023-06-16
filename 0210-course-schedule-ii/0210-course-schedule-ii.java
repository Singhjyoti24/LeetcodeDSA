class Solution {
    public int[] findOrder(int n, int[][] grid) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        
        for(int i=0;i<grid.length;i++){
            adj.get(grid[i][1]).add(grid[i][0]);
        }
        
        return toposort(adj, n);
    }
    
    public int[] toposort(ArrayList<ArrayList<Integer>> adj, int V){
        int[] indegree = new int[V];
        int[] ans = new int[V];
        Queue<Integer> q = new LinkedList<>();
        
        for(int i=0;i<V;i++){
            for(Integer ni : adj.get(i)){
                indegree[ni]++;
            }
        }
        
        for(int i=0;i<V;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }

        int j = 0, ct = 0;
        while(!q.isEmpty()){
            int a = q.poll();
            ans[j++] = a;
            ct++;
            
            for(Integer ni : adj.get(a)){
                indegree[ni]--;
                if(indegree[ni]==0){
                    q.add(ni);
                }
            }
        }
        
        if(ct==V){
            return ans;
        }
        
        int[] b = new int[0];
        return b;
    }
}