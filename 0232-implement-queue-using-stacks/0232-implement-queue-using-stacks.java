class MyQueue {

    Stack<Integer> st = new Stack<>();
    Stack<Integer> pt = new Stack<>();
    public MyQueue() {
        
    }
    
    public void push(int x) {
        st.push(x);
    }
    
    public int pop() {
        int a = 0;
        while(!st.isEmpty()){
            a = st.peek();
            if(st.size()==1){
                st.pop();
            }else{
                pt.push(st.pop());
            }
        }
        
        while(!pt.isEmpty()){
            st.push(pt.pop());
        }
        return a;
    }
    
    public int peek() {
        int a = 0;
        while(!st.isEmpty()){
            a = st.peek();
            pt.push(st.pop());
        }
        
        while(!pt.isEmpty()){
            st.push(pt.pop());
        }
        return a;
    }
    
    public boolean empty() {
        return st.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */