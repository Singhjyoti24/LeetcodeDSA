class Solution {
    public int bestTeamScore(int[] scores, int[] ages) {
        int n = ages.length;
        int[][] arr = new int[n][2];
        
        for(int i=0;i<n;i++){
            arr[i][0] = ages[i];
            arr[i][1] = scores[i];
        }
        
        Arrays.sort(arr, (a,b)->a[0]==b[0]?a[1]-b[1]:a[0]-b[0]);
        
        return helper(arr);
    }
    
    private int helper(int[][] arr){
        int n = arr.length;
        int ans = 0;
        
        int[] dp = new int[n];
         for (int i = 0; i < n; i++) {
            dp[i] = arr[i][1];
            ans = Math.max(ans, dp[i]);
        }
        
        
        for(int i=0;i<n;i++){
            for(int j=i-1;j>=0;j--){
                if(arr[i][1]>=arr[j][1]){
                    dp[i] = Math.max(dp[i], arr[i][1] + dp[j]);
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}