class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        
        int n = graph.length;
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        
        for(int i=0;i<n;i++){
            for(int j=0;j<graph[i].length;j++){
                adj.get(i).add(graph[i][j]);
            }
        }
        
        List<Integer> ans = new ArrayList<>();
        boolean[] vis = new boolean[n];
        int[] pathVis = new int[n];
        for(int i=0;i<n;i++){
            if(!vis[i]){
                isCycle(adj, i, vis, pathVis, ans);
            }
        }
        
        Collections.sort(ans);
        return ans;
    }
    
    public boolean isCycle(ArrayList<ArrayList<Integer>> adj, int start, boolean[] vis, int[] pathVis, List<Integer> ans){
        vis[start] = true;
        pathVis[start] = 1;
        
        for(Integer ni : adj.get(start)){
            if(!vis[ni] && isCycle(adj, ni, vis, pathVis, ans)){
                return true;
            }else if(pathVis[ni]==1){
                return true;
            }
        }
        
        pathVis[start] = 0;
        ans.add(start);
        return false;
    }
}