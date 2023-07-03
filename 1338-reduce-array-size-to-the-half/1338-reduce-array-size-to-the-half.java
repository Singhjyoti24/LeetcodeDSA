class Pair{
    int ct;
    int ele;
    
    Pair(int a, int b){
        ct = a;
        ele = b;
    }
}

class Solution {
    public int minSetSize(int[] arr) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->b.ct-a.ct);
        
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
        }
        
        for(Map.Entry<Integer, Integer> mp : map.entrySet()){
            pq.add(new Pair(mp.getValue(), mp.getKey()));
        }
        
        int ct = 0, n = arr.length;
        while(!pq.isEmpty()){
            Pair p = pq.poll();
            n -= p.ct;
            System.out.println(n);
            ct++;
            
            if(n<=arr.length/2){
                return ct;
            }
        }
        
        return ct;
    }
}