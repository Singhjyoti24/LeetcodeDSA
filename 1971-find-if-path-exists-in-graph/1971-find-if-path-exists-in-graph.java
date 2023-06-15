class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<Integer>());
        }
        
        for(int i=0;i<edges.length;i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        
        boolean[] vis = new boolean[n];
        if(bfs(adj, vis, source, destination)){
            return true;
        }
        
        return false;
    }
    
    public boolean bfs(ArrayList<ArrayList<Integer>> adj, boolean[] vis, int source, int destination){
        Queue<Integer> q = new LinkedList<>();
        q.add(source);
        vis[source] = true;
        
        while(!q.isEmpty()){
            int node = q.poll();
            if(node==destination){
                return true;
            }
            
            for(Integer ni: adj.get(node)){
                if(!vis[ni]){
                    q.add(ni);
                    vis[ni] = true;
                }
            }
        }
        
        return false;
    }
}