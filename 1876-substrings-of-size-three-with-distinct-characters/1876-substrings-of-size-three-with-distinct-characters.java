class Solution {
    public int countGoodSubstrings(String s) {
        if(s.length()<3){
            return 0;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        
        for(int i=0;i<3;i++){
            if(map.containsKey(s.charAt(i))){
                map.put(s.charAt(i), map.get(s.charAt(i))+1);
            }else{
                map.put(s.charAt(i), 1);
            }
        }
        
        int cnt = 0;
        if(map.size()==3){
            cnt++;
        }
        
        for(int i=3;i<s.length();i++){
            if(map.containsKey(s.charAt(i))){
                map.put(s.charAt(i), map.get(s.charAt(i))+1);
            }else{
                map.put(s.charAt(i), 1);
            }
            
            char ch = s.charAt(i-3);
            if(map.get(ch)>1){
                map.put(ch, map.get(ch)-1);
            }else{
                map.remove(ch);
            }
            
            if(map.size()==3){
                cnt++;
            }
        }
        
        return cnt;
    }
}