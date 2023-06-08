class Pair{
    int first;
    int second;
    
    Pair(int a, int b){
        first = a;
        second = b;
    }
}

class Solution {
    public int[][] merge(int[][] arr) {
        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));
        int n = arr.length;
        if(n==1){
            return arr;
        }
        int start = arr[0][0], end = arr[0][1];
        
        ArrayList<Pair> ans = new ArrayList<>();
        for(int i=1;i<n;i++){
            if(arr[i][0]<=end){
                end = Math.max(end, arr[i][1]);
            }else{
                ans.add(new Pair(start, end));
                start = arr[i][0];
                end = arr[i][1];
            }
        }
        ans.add(new Pair(start, end));
        
        int[][] brr = new int[ans.size()][2];
        for(int i=0;i<brr.length;i++){
            Pair p = ans.get(i);
            brr[i][0] = p.first;
            brr[i][1] = p.second;
        }
        return brr;
    }
}