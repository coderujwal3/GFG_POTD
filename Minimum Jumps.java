class Solution {
    static int minJumps(int[] arr) {
        // code here
        int n = arr.length;
        int max = 0;
        int choice = 0;
        int jumps = 0;
        for(int i = 0; i < n - 1; i++) {
            max = Math.max(max, arr[i] + i);
            if(i == choice) {
                choice = max;
                jumps++;
            }
            if(choice >= n - 1) return jumps;
        }
        return -1;
    }
}
