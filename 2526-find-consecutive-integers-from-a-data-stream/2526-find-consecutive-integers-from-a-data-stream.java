class DataStream {
    int val = 0, ct = 0, t = 0;
    public DataStream(int value, int k) {
        val = value;
        t = k;
    }
    
    public boolean consec(int num) {
        if(num == val){
            ct++;
        }else{
            ct = 0;
        }
        
        if(ct>=t){
            return true;
        }
        return false;
    }
}

/**
 * Your DataStream object will be instantiated and called as such:
 * DataStream obj = new DataStream(value, k);
 * boolean param_1 = obj.consec(num);
 */