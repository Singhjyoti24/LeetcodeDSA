class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<k;i++){
            ans.add(arr[i]);
        }
        
        int j = 0;
        for(int i=k;i<arr.length;i++){
            if(Math.abs(arr[i]-x)<Math.abs(ans.get(j)-x)){
                ans.remove(j);
                ans.add(arr[i]);
            }
            
        }
        return ans;
    }
}