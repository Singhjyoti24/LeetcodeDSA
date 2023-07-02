class Pair{
    int ct = 0;
    int ele = 0;
    
    public Pair(int a, int b){
        ct = a;
        ele = b;
    }
}

class Solution {
    public int[] rearrangeBarcodes(int[] arr) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->b.ct-a.ct);
        int n = arr.length;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
        }
        
        for(Map.Entry<Integer, Integer> hm : map.entrySet()){
            pq.add(new Pair(hm.getValue(), hm.getKey()));
        }
        
        int[] ans = new int[n];
        int j = 0;
        Pair prev = null;
        while(!pq.isEmpty()){
            Pair p = pq.poll();
            ans[j++] = p.ele;
            
            if(prev!=null){
                pq.add(prev);
                prev = null;
            }
            
            int nct = p.ct-1;
            if(nct>0){
                prev = new Pair(nct, p.ele);
            }
        }
        return ans;
    }
}