class Solution {
    public int arrangeCoins(int n) {
        long low = 0, high = n, res = 0;
        
        while(low<=high){
            long mid = low+(high-low)/2;
            
            if((mid*(mid+1))/2 == n){
                return (int)mid;
            }else if((mid*(mid+1))/2 > n){
                high = mid-1;
            }else{
                res = low;
                low = mid+1;
            }
        }
        
        return (int)high;
    }
}