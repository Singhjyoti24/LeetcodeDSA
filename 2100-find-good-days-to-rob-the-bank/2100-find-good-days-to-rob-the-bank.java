class Solution {
    public List<Integer> goodDaysToRobBank(int[] arr, int time) {
        List<Integer> ans = new ArrayList<>();
        
        int n = arr.length;
        int[] r = new int[n];
        int[] l = new int[n];
        
        for(int i=1;i<n;i++){
            if(arr[i-1]>=arr[i]){
                l[i] = l[i-1] + 1;
            }
        }
        
        for(int i=n-2;i>=0;i--){
            if(arr[i+1]>=arr[i]){
                r[i] = r[i+1] + 1;
            }
        }
        
        for(int i=0;i<n;i++){
            if(l[i]>=time && r[i]>=time){
                ans.add(i);
            }
        }
        return ans;
    }
}