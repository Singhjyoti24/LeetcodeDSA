class Solution {
    public int shipWithinDays(int[] arr, int days) {
        int n = arr.length;
        
        int low = 0, high = 0;
        for(int i=0;i<n;i++){
            high += arr[i];
        }
        
        int limit = 0;
        while(low<=high){
            int mid = low+(high-low)/2;
            
            if(isPossible(arr, mid, days)){
                limit = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        
        return limit;
    }
    
    private boolean isPossible(int[] arr, int mid, int days){
        int sum = 0, ct = 1;
        
        for(int i=0;i<arr.length;i++){
            if(arr[i]>mid){
                return false;
            }
            if(sum+arr[i]>mid){
                ct++;
                
                sum = arr[i];
                if(ct>days){
                    return false;
                }
            }else{
                sum += arr[i];
            }
        }
        
        return true;
    }
}