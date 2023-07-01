class Solution {
    public String removeStars(String s) {
        Stack<Character> st = new Stack<>();
        
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            
            if(ch != '*'){
                st.push(ch);
            }else if(!st.isEmpty()){
                st.pop();
            }
        }
        
        String ans = "";
        while(!st.isEmpty()){
            ans = st.pop() + ans;
        }
        
        return ans;
    }
}