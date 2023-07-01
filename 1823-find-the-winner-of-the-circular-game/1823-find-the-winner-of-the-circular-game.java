class Solution {
    public int findTheWinner(int n, int k) {
        List<Integer> arr = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            arr.add(i);
        } 
        
        return helper(k, arr, 0);
    }
    
    public int helper(int k, List<Integer> list, int i){
        if(list.size() == 1) return list.get(0);
        i = (i + k - 1) % list.size();
        list.remove(i);
        return helper(k, list, i);
    }
}