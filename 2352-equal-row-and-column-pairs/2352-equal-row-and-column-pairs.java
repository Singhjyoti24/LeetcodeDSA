class Solution {
    public int equalPairs(int[][] grid) {
        int n = grid.length;
        
        int ct = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(isTrue(grid, i, j)){
                    ct++;
                }
            }
        }
        
        return ct;
    }
    
    public boolean isTrue(int[][] grid, int row, int col){
        for(int i=0;i<grid.length;i++){
            if(grid[row][i]!=grid[i][col]){
                return false;
            }
        }
        
        return true;
    }
}