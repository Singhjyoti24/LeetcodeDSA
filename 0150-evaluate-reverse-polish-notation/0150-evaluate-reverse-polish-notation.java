class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        
        for(int i=0;i<tokens.length;i++){
            String ai = tokens[i];
            
            if(ai.equals("+")){
                int a = st.pop();
                int b = st.pop();
                st.add(a+b);
            }else if(ai.equals("-")){
                int a = st.pop();
                int b = st.pop();
                st.add(b-a);
            }else if(ai.equals("*")){
                int a = st.pop();
                int b = st.pop();
                st.add(a*b);
            }else if(ai.equals("/")){
                int a = st.pop();
                int b = st.pop();
                st.add(b/a);
            }else{
                st.add(Integer.parseInt(ai));
            }
        }
        
        return st.pop();
    }
}