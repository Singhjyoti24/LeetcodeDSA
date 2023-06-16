class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<rooms.size();i++){
            adj.add(new ArrayList<>());
        }
        
        for(int i=0;i<rooms.size();i++){
            for(int j=0;j<rooms.get(i).size();j++){
                adj.get(i).add(rooms.get(i).get(j));
            }
        }
        
        boolean[] vis = new boolean[rooms.size()];
        dfs(adj, 0, vis);
        
        for(int i=0;i<vis.length;i++){
            if(!vis[i]){
                return false;
            }
        }
        
        return true;
    }
    
    public void dfs(ArrayList<ArrayList<Integer>> adj, int node, boolean[] vis){
        vis[node] = true;
        
        for(Integer ni: adj.get(node)){
            if(vis[ni]==false){
                dfs(adj, ni, vis);
            }
        }
    }
}