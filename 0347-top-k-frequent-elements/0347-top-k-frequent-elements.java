class Pair{
    int cnt;
    int ele;
    
    Pair(int a, int b){
        cnt = a;
        ele = b;
    }
}

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[k];
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b)->b.cnt-a.cnt);
        
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i], map.get(nums[i])+1);
            }else{
                map.put(nums[i], 1);
            }
        }
        
        for (Map.Entry<Integer,Integer> mapElement : map.entrySet()) {
            pq.add(new Pair( mapElement.getValue(), mapElement.getKey()));
        }
        
        for(int i=0;i<k;i++){
            ans[i] = pq.poll().ele;
        }
        
        return ans;
    }
}