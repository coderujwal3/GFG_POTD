class Solution {
    static Boolean isSubsetSum(int arr[], int sum) {
        // code here
        int n = arr.length;
        Boolean[][] dp = new Boolean[n][sum+1];
        return res(n-1, arr, sum, dp);
    }
    private static Boolean res(int id,int arr[],int sum,Boolean dp[][]){
        if(sum == 0) return true;
        if(id < 0 || sum < 0) return false;
        if(dp[id][sum] != null) return dp[id][sum];
        Boolean p = res(id - 1, arr, sum - arr[id], dp);
        Boolean np = res(id - 1, arr, sum, dp);
        return dp[id][sum] = p || np;
    }
}
