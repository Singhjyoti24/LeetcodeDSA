class Solution {
    public int eraseOverlapIntervals(int[][] arr) {
        if(arr.length<=1){
            return 0;
        }
        Arrays.sort(arr, (a,b)->a[1]-b[1]);
        
        int ct = 0;
        int end = Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            if(arr[i][0]<end){
                ct++;
            }else{
                end = arr[i][1];
            }
        }
        
        return ct;
    }
}