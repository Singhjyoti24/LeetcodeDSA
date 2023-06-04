class Pair{
    int a; int b;
    
    Pair(int a, int b){
        this.a = a;
        this.b = b;
    }
}

class StockSpanner {
    Stack<Pair> st;
    public StockSpanner() {
        st = new Stack<>();
    }
    
    public int next(int price) {
        if(st.isEmpty()){
            st.add(new Pair(price, 1));
            return 1;
        }
        
        int ret = 1;
        while(!st.isEmpty() && st.peek().a<=price){
            ret += st.peek().b;
            st.pop();
        }
        
        st.add(new Pair(price, ret));
        return ret;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */