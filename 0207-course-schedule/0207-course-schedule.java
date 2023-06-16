class Solution {
    public boolean canFinish(int n, int[][] grid) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        
        for(int i=0;i<grid.length;i++){
            adj.get(grid[i][1]).add(grid[i][0]);
        }
        
        int a = toposort(adj, n);
        if(a==n){
            return true;
        }
        
        return false;
    }
    
    public int toposort(ArrayList<ArrayList<Integer>> adj, int V){
        int[] indegree = new int[V];
        Queue<Integer> q = new LinkedList<>();
        int ct = 0;
        
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

        while(!q.isEmpty()){
            int a = q.poll();
            ct++;
            
            for(Integer ni : adj.get(a)){
                indegree[ni]--;
                if(indegree[ni]==0){
                    q.add(ni);
                }
            }
        }
        
        return ct;
    }
}