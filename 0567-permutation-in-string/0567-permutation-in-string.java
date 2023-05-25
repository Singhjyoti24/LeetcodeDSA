class Solution {
    public boolean checkInclusion(String p, String s) {
        if(s.length()<p.length()){
            return false;
        }
        
        HashMap<Character, Integer> map = new HashMap<>();
        HashMap<Character, Integer> nap = new HashMap<>();
        int k = p.length();
        
        for(int i=0;i<k;i++){
            if(map.containsKey(s.charAt(i))){
                map.put(s.charAt(i), map.get(s.charAt(i))+1);
            }else{
                map.put(s.charAt(i), 1);
            }
            
            if(nap.containsKey(p.charAt(i))){
                nap.put(p.charAt(i), nap.get(p.charAt(i))+1);
            }else{
                nap.put(p.charAt(i), 1);
            }
        }
        
        if(map.equals(nap)){
            return true;
        }
        
        for(int i=k;i<s.length();i++){
            if(map.containsKey(s.charAt(i))){
                map.put(s.charAt(i), map.get(s.charAt(i))+1);
            }else{
                map.put(s.charAt(i), 1);
            }
            
            if(map.get(s.charAt(i-k))>1){
                map.put(s.charAt(i-k), map.get(s.charAt(i-k))-1);
            }else{
                map.remove(s.charAt(i-k));
            }
            
            if(map.equals(nap)){
                 return true;
            }
        }
        
        return false;
    }
}