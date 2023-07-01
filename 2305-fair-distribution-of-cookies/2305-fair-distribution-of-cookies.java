class Solution {
    public int distributeCookies(int[] arr, int k) {
        int[] dp = new int[k];
        return dfs(0, dp, arr, k, k);
    }
    
    private int dfs(int i, int[] dp, int[] arr, int k, int ct){
        if(arr.length-i<ct){
            return Integer.MAX_VALUE;  
        }
        
        if (i == arr.length) {
            int unfairness = Integer.MIN_VALUE;
            for (int value : dp) {
                unfairness = Math.max(unfairness, value);
            }
            return unfairness;
        }
        
        int answer = Integer.MAX_VALUE;
        for (int j = 0; j < k; ++j) {
            ct -= dp[j] == 0 ? 1 : 0;
            dp[j] += arr[i];
            
            answer = Math.min(answer, dfs(i + 1, dp, arr, k, ct));
            
            dp[j] -= arr[i];
            ct += dp[j] == 0 ? 1 : 0;
        }
        
        return answer;
    }
}