class Solution {
    public int maxConsecutiveAnswers(String str, int k) {
        HashMap<Character, Integer> map = new HashMap<>();
        int j = 0;
        
        int max = 0;
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            if(map.containsKey(ch)){
                map.put(ch, map.get(ch)+1);
            }else{
                map.put(ch, 1);
            }
            
            if(map.containsKey('T') && map.containsKey('F')){
                int a =  map.get('T');
                int b =  map.get('F');
                int c = 0;
                if((a>=b && b<=k) || (b>=a && a<=k)){
                max = Math.max(max, i-j+1);
                }
                
                
                while((a>=b && b>k) || (b>=a && a>k)){
                if(map.get(str.charAt(j))>1){
                    map.put(str.charAt(j), map.get(str.charAt(j))-1);
                }else{
                    map.remove(str.charAt(j));
                }
                    if(map.containsKey('T')){
                        a = map.get('T');
                    }else{
                        a = 0;
                    }
                    if(map.containsKey('F')){
                        b = map.get('F');
                    }else{
                        b = 0;
                    }
                    j++;
            }
            }else{
                max = Math.max(max, i-j+1);
            }
        }
        
        return max;
    }
}