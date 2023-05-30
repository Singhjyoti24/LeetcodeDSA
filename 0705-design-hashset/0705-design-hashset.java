class MyHashSet {
    int[] arr = new int[10000000];

    public MyHashSet() {
        
    }
    
    public void add(int key) {
        arr[key]++;
    }
    
    public void remove(int key) {
        arr[key] = 0;
    }
    
    public boolean contains(int key) {
        if(arr[key]<=0){
            return false;
        }
        
        return true;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */