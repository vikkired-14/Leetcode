class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        dp[0] =1;
        dp[1] = 1;
        return helper(n,dp);
    }

    public int helper(int n,int[] dp){
        if(dp[n]!=-1)
          return dp[n];
        int steps = helper(n-1,dp) + helper(n-2,dp);
        dp[n] = steps;
        return dp[n];  
    }
}