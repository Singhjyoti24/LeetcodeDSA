class Solution {
    public int longestPalindrome(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(map.containsKey(ch)){
                map.put(ch, map.get(ch)+1);
            }else{
                map.put(ch, 1);
            }
        }
        
        int ans = 0, flag = 0;
        for(Character ch : map.keySet()){
            if(map.get(ch)%2==0){
                ans += map.get(ch);
            }else if(map.get(ch)%2!=0){
                if(flag==0){
                    flag = 1;
                    ans += map.get(ch); 
                }else{
                ans += map.get(ch) - 1;}
            }
        }
        
        return ans;
    }
}