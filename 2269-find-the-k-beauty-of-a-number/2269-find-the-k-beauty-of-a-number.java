class Solution {
    public int divisorSubstrings(int num, int k) {
        String s = String.valueOf(num);
        
        int cnt = 0;
        String str = "";
        for(int i=0;i<k;i++){
            str += s.charAt(i);
            
            if(str.length()==k){
                int n = Integer.parseInt(str);
                if(n!=0 && num%n==0){
                    cnt++;
                }
            }
        }
        
        for(int i=k;i<s.length();i++){
            String res = str.substring(1);
            res += s.charAt(i);
            
            int n = Integer.parseInt(res);
            if(n!=0 && num%n==0){
                cnt++;
            }
            str = res;
        }
        
        return cnt;
    }
}