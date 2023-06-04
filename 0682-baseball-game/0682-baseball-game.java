class Solution {
    public int calPoints(String[] op) {
        Stack<Integer> st = new Stack<>();
        
        for(int i=0;i<op.length;i++){
            String a = op[i];
            
            if(a.equals("+")){
                int b = st.pop();
                int c = st.peek();
                st.add(b);
                st.add(b+c);
            }else if(a.equals("C")){
                st.pop();
            }else if(a.equals("D")){
                st.add(2*st.peek());
            }else{
                st.add(Integer.parseInt(a));
            }
        }
        
        int sum = 0;
        while(!st.isEmpty()){
            sum += st.pop();
        }
        
        return sum;
    }
}