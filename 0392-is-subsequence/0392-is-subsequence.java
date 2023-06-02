class Solution {
    public boolean isSubsequence(String s, String t) {
        if(s.length()==0){
            return true;
        }else if(t.length()<s.length()){
            return false;
        }
        
        int j = 0;
        for(int i=0;i<t.length();i++){
            if(s.charAt(j)==t.charAt(i)){
                j++;
                if(j==s.length()){
                    return true;
                }
            }
        }
        
        if(j==s.length()){
            return true;
        }
        return false;
    }
}