class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        if(p.length()>s.length()){
            List<Integer> ans = new ArrayList<>();
            return ans;
        }
        List<Integer> ans = new ArrayList<>();
        
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
            ans.add(0);
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
                 ans.add(i-k+1);
            }
        }
        return ans;
    }
}