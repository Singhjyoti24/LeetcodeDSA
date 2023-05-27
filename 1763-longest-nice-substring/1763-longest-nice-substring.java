class Solution {
    public String longestNiceSubstring(String s) {
        if(s.length()<2){
            return "";
        }
        
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i), i);
        }
        
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(map.containsKey(Character.toLowerCase(ch)) && map.containsKey(Character.toUpperCase(ch))){
                continue;
            }
            
            String str1 = longestNiceSubstring(s.substring(0,i));
            String str2 = longestNiceSubstring(s.substring(i+1));
            return str1.length()>=str2.length()?str1:str2;
        }
        
        return s;
    }
}