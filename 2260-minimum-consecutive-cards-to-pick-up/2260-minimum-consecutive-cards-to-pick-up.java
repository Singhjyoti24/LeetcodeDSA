class Solution {
    public int minimumCardPickup(int[] cards) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        int ans = Integer.MAX_VALUE;
        for(int i=0;i<cards.length;i++){
            if(map.containsKey(cards[i])){
                ans = Math.min(ans, i-map.get(cards[i])+1);
            }
            
            map.put(cards[i], i);
        }
        
        if(ans==Integer.MAX_VALUE){
            return -1;
        }
        return ans;
    }
}