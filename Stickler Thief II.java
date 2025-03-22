class Solution {
    int maxValue(int[] arr) {
        // code here
        int n = arr.length;
        int[] dp1 = new int[n];
        int[] dp2 = new int[n];
        Arrays.fill(dp1, -1);
        Arrays.fill(dp2, -1);
        
        return Math.max(res(n-2, arr, dp1, false), res(n-1, arr, dp2, true));
    }
    int res(int ind, int arr[], int dp[], boolean fl){
        if(fl == false)
        if(ind < 0) return 0;
        if(fl == true)
        if(ind <= 0) return 0;
        if(dp[ind] != -1) return dp[ind];
        int nt = res(ind-1, arr, dp,fl);
        int t = arr[ind] + res(ind-2, arr, dp, fl);
        
        return dp[ind] = Math.max(nt, t);
    }
}
