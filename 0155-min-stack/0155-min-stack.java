class MinStack {

    Stack<Integer> st = new Stack<>();
    Stack<Integer> pt = new Stack<>();
    public MinStack() {
        
    }
    
    public void push(int val) {
            st.add(val);
            if(pt.isEmpty() || getMin()>=val){
                pt.add(val);
            }
    }
    
    public void pop() {
        int a = st.pop();
        
        if(pt.peek()==a){
            pt.pop();
        }
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        return pt.peek();
    }
}
/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */