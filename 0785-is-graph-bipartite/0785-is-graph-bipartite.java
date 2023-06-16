class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        for(int i=0;i<n;i++){
            color[i] = -1;
        }
        
        for (int i = 0; i < n; i++) {
            if (color[i] == -1 && !isBipartite(graph, i, color)) {
                return false;
            }
        }
        
        return true;
    }
    
    public boolean isBipartite(int[][] graph, int start, int[] color){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        color[start] = 0;
        
        while(!q.isEmpty()){
            int node = q.poll();
            
            for(Integer ni : graph[node]){
                if(color[ni]==-1){
                    color[ni] = 1-color[node];
                    q.add(ni);
                }else if(color[ni]==color[node]){
                    return false;
                }
            }
        }
        
        return true;
    }
}