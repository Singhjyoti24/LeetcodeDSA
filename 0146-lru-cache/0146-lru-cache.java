class LRUCache {
    LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
    int cap = 0;
    public LRUCache(int capacity) {
        cap = capacity;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }
        
        int val = map.get(key);
        map.remove(key);
        map.put(key, val);
        return map.get(key);
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            map.remove(key);
            map.put(key, value);
            return;
        }
        
        if(map.size()>=cap){
            Integer lru = map.keySet().iterator().next();
            map.remove(lru);
        }
        map.put(key, value);
    }
}