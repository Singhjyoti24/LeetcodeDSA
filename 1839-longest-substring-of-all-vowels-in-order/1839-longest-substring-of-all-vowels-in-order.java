class Solution {
    public int longestBeautifulSubstring(String word) {
        int ct = 0, max = 0, j = 0;
        
        for(int i=0;i<word.length();i++){
            if(i==0 || word.charAt(i)>word.charAt(i-1)){
                ct++;
            }
            if(i>0 && word.charAt(i)<word.charAt(i-1)){
                j = i;
                ct = 1;
            }
            
            if(ct==5){
                max = Math.max(max, i-j+1);
            }
        }
        
        return max;
    }
}

