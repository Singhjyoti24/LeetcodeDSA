class Solution {
    public boolean buddyStrings(String s, String goal) {
        if(s.length()!=goal.length()){
            return false;
        }
        
        if(s.equals(goal)){
            int[] frequency = new int[26];
            for (char ch : s.toCharArray()) {
                frequency[ch - 'a'] += 1;
                if (frequency[ch - 'a'] == 2) {
                    return true;
                }
            }
            return false;
        }
        
        int fi = -1, si = -1;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)!=goal.charAt(i)){
                if(fi==-1){
                    fi = i;
                }else if(si==-1){
                    si = i;
                }else{
                    return false;
                }
            }
        }
        
        if(si==-1){
            return false;
        }
        
        return s.charAt(fi)==goal.charAt(si) && s.charAt(si)==goal.charAt(fi);
    }
}