class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        
        int j = 0, ans = 0;
        for(int i=0;i<s.length();i++){
            if(map.containsKey(s.charAt(i))){
                map.put(s.charAt(i), map.get(s.charAt(i))+1);
            }else{
                map.put(s.charAt(i), 1); 
            }
            
            if(map.size()==i-j+1){
                ans = Math.max(ans, i-j+1);
            }
            
            while(map.size()<i-j+1){
                if(map.get(s.charAt(j))>1){
                map.put(s.charAt(j), map.get(s.charAt(j))-1);
            }else{
                map.remove(s.charAt(j)); 
            }
                j++;
            }
        }
        
        return ans;
    }
}