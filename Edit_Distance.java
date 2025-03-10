class Solution {
    public int editDistance(String s1, String s2) {
        // Code here
        int len1 = s1.length();
        int len2 = s2.length();
        int[][] dp = new int[len1+1][len2+1];
        for(int[] row:dp) Arrays.fill(row, -1);
        return find(s1, s2, len1, len2, dp);
    }
    private int find(String s1,String s2, int i,int j,int[][] dp) {
        if(i == 0) return j;
        if(j == 0) return i;
        if(dp[i][j] != -1) return dp[i][j];
        if(s1.charAt(i-1) == s2.charAt(j-1)) return dp[i][j] = find(s1,s2,i-1,j-1,dp);
        int rem = find(s1,s2,i-1,j,dp);
        int insert = find(s1,s2,i,j-1,dp);
        int replace = find(s1,s2,i-1,j-1,dp);
        return dp[i][j]= 1 + Math.min(rem,Math.min(insert,replace));
    }
}
