class Pair{
    int cnt;
    char ch;
    
    Pair(int a, char b){
        cnt = a;
        ch = b;
    }
}

class Solution {
    public String frequencySort(String s) {
        int n = s.length();
        String ans = "";
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b)->b.cnt-a.cnt);
        
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            char ch = s.charAt(i);
            if(map.containsKey(ch)){
                map.put(ch, map.get(ch)+1);
            }else{
                map.put(ch, 1);
            }
        }
        
        for (Map.Entry<Character,Integer> mapElement : map.entrySet()) {
            pq.add(new Pair(mapElement.getValue(), mapElement.getKey()));
        }
        
        
        while(!pq.isEmpty()){
            int a = pq.peek().cnt;
            char ch = pq.peek().ch;
            pq.poll();
            while(a!=0){
                ans += ch;
                a--;
            }
        }
        
        return ans;
    }
}