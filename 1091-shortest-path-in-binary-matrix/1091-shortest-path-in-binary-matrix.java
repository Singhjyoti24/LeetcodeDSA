class Pair{
    int x;
    int y;
    int dis;
    
    Pair(int x, int y, int dis){
        this.x = x;
        this.y = y;
        this.dis = dis;
    }
}

class Solution {
    public int shortestPathBinaryMatrix(int[][] grid){
        if(grid[0][0]==1){
            return -1;
        }
        int n = grid.length;
        if(n==1){
            return 1;
        }
        
        int[][] vis = new int[n][n];
        vis[0][0] = 1;
        
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0,0,1));
        
        while(!q.isEmpty()){
            Pair p = q.poll();
            int x = p.x;
            int y = p.y;
            int dis = p.dis;
            
            if(x-1>=0 && y-1>=0 && grid[x-1][y-1]==0 && vis[x-1][y-1]==0){
                q.add(new Pair(x-1,y-1,dis+1));
                vis[x-1][y-1] = 1;
            }
            if(x-1>=0 && y>=0 && grid[x-1][y]==0 && vis[x-1][y]==0){
                q.add(new Pair(x-1,y,dis+1));
                vis[x-1][y] = 1;
            }
            if(x-1>=0 && y+1<n && grid[x-1][y+1]==0 && vis[x-1][y+1]==0){
                q.add(new Pair(x-1,y+1,dis+1));
                vis[x-1][y+1] = 1;
            }
            if(x>=0 && y+1<n && grid[x][y+1]==0 && vis[x][y+1]==0){
                q.add(new Pair(x,y+1,dis+1));
                vis[x][y+1] = 1;
            }
            if(x>=0 && y-1>=0 && grid[x][y-1]==0 && vis[x][y-1]==0){
                q.add(new Pair(x,y-1,dis+1));
                vis[x][y-1] = 1;
            }
            if(x+1<n && y<n && grid[x+1][y]==0 && vis[x+1][y]==0){
                q.add(new Pair(x+1,y,dis+1));
                vis[x+1][y] = 1;
            }
            if(x+1<n && y-1>=0 && grid[x+1][y-1]==0 && vis[x+1][y-1]==0){
                q.add(new Pair(x+1,y-1,dis+1));
                vis[x+1][y-1] = 1;
            }
            if(x+1<n && y+1<n && grid[x+1][y+1]==0 && vis[x+1][y+1]==0){
                q.add(new Pair(x+1,y+1,dis+1));
                vis[x+1][y+1] = 1;
            }
            
            if(!q.isEmpty() && q.peek().x==n-1 && q.peek().y==n-1){
                return q.peek().dis;
            }
        }
        
        return -1;
    }
}