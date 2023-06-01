class Solution {
    public List<List<Integer>> generate(int n) {
        List<List<Integer>> ans = new ArrayList<>();
        // if(n==1){
        //     List<Integer> arr = new ArrayList<>();
        //     arr.add(1);
        //     ans.add(arr);
        //     return arr;
        // }
        
        List<Integer> arr = new ArrayList<>();
        arr.add(1);
        ans.add(arr);
        int k = 0;
        for(int i=2;i<=n;i++){
            arr = new ArrayList<>();
            List<Integer> prev = ans.get(k);
            for(int j=0;j<i;j++){
                if(j==0 || j==i-1){
                    arr.add(1);
                }else{
                    arr.add(prev.get(j)+prev.get(j-1));
                }
            }
            ans.add(arr);
            k++;
        }
        
        return ans;
    }
}