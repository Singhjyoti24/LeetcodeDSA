class MyStack {

    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();
    public MyStack() {
        
    }
    
    public void push(int x) {
        q1.add(x);
    }
    
    public int pop() {
        int a = 0;
        while(!q1.isEmpty()){
            a = q1.peek();
            if(q1.size()==1){
                q1.poll();
            }else{
                q2.add(q1.poll());
            }
        }
        
        while(!q2.isEmpty()){
            q1.add(q2.poll());
        }
        
        return a;
    }
    
    public int top() {
        int a = 0;
        while(!q1.isEmpty()){
            a = q1.peek();
            q2.add(q1.poll());
        }
        
        while(!q2.isEmpty()){
            q1.add(q2.poll());
        }
        
        return a;
    }
    
    public boolean empty() {
        return q1.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */