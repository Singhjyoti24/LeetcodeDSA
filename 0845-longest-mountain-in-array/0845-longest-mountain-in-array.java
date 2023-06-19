class Solution {
    public int longestMountain(int[] arr) {
        int n = arr.length;
        if(n<=2){
            return 0;
        }
        
        int[] r = new int[n];
        r[n-1] = 1;
        for(int i=n-2;i>=0;i--){
            if(arr[i+1]<arr[i]){
                r[i] = r[i+1] + 1;
            }else{
                r[i] = 1;
            }
        }
        
        int[] l = new int[n];
        l[0] = 1;
        for(int i=1;i<n;i++){
            if(arr[i-1]<arr[i]){
                l[i] = l[i-1] + 1;
            }else{
                l[i] = 1;
            }
        }
        
        int max = 0;
        for(int i=0;i<n;i++){
            if(l[i]>1 && r[i]>1){
                max = Math.max(l[i]+r[i]-1, max);
            }
        }
        
        return max;
    }
}