class Solution {
    public int findCircleNum(int[][] graph) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<=graph.length;i++){
            adj.add(new ArrayList<>());
        }
        
        for(int i=0;i<graph.length;i++){
            for(int j=0;j<graph[i].length;j++){
                if(i!=j && graph[i][j]==1){
                    adj.get(i+1).add(j+1);
                    adj.get(j+1).add(i+1);
                }
            }
        }
        boolean[] vis = new boolean[graph.length + 1];
        int province = 0;
        
        for(int i=1;i<=graph.length;i++){
            if(vis[i]==false){
                bfs(adj, i, vis);
                province++;
            }
        }
        return province;
    }
    
    public void bfs(ArrayList<ArrayList<Integer>> adj, int start, boolean[] vis){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        vis[start] = true;

        while (!q.isEmpty()) {
            int node = q.poll();

            for (Integer ni : adj.get(node)) {
                if (!vis[ni]) {
                    vis[ni] = true;
                    q.add(ni);
                }
            }
        }
    }
}