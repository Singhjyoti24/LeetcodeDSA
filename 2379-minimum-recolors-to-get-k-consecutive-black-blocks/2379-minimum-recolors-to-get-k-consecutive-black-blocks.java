class Solution {
    public int minimumRecolors(String blocks, int k) {
        int ct = 0;
        int min = 0;
        
        for(int i=0;i<k;i++){
            if(blocks.charAt(i)=='W'){
                ct++;
            }
        }
        
        min = ct;
        for(int i=k;i<blocks.length();i++){
            if(blocks.charAt(i)=='W'){
                ct++;
            }
            
            if(blocks.charAt(i-k)=='W'){
                ct--;
            }
            
            min = Math.min(min, ct);
        }
        return min;
    }
}