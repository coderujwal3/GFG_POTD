class Solution {
    static Boolean[][] dp;
    static boolean equalPartition(int arr[]) {
        // code here
        int sum = Arrays.stream(arr).sum();
        if(sum % 2 != 0) return false;
        int x = sum / 2;
        dp = new Boolean[arr.length][x + 1];
        return res(0, arr, x);
    }
    static boolean res(int ind, int[] arr, int sum){
        if(ind == arr.length) return sum == 0 ? true : false;
        if(dp[ind][sum] != null) return dp[ind][sum];
        boolean res = false;
        if(arr[ind] <= sum) res |= res(ind + 1, arr, sum - arr[ind]);
        res |= res(ind + 1, arr, sum);
        return dp[ind][sum] = res;
    }
}
