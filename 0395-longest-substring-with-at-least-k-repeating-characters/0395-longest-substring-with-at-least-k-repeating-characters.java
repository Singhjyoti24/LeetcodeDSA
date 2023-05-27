class Solution {
    public int longestSubstring(String s, int k) {
        if(s.length()<k){
            return 0;
        }
        
        return helper(s,k).length();
    }
    
    public String helper(String s, int k){
        if(s.length()<k){
            return "";
        }
        HashMap<Character, Integer> map = new HashMap<>();
        
        for(int i=0;i<s.length();i++){
            if(map.containsKey(s.charAt(i))){
                map.put(s.charAt(i), map.get(s.charAt(i))+1);
            }else{
                map.put(s.charAt(i), 1);
            }
        }
        
        for(int i=0;i<s.length();i++){
            if(map.get(s.charAt(i))>=k){
                continue;
            }
            
            String str1 = s.substring(0,i), str2 = s.substring(i+1);
            String a = helper(str1, k);
            String b = helper(str2, k);
            return a.length()>=b.length()?a:b;
        }
        
        return s;
    }
}