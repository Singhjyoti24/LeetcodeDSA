class Solution {
    public int numRescueBoats(int[] arr, int limit) {
        Arrays.sort(arr);
        
        int ct = 0, i = 0, j = arr.length-1;
        while(i<=j){
            ct++;
            if(arr[i]+arr[j]<=limit){
                i++;
            }
            j--;
        }
        
        return ct;
    }
}