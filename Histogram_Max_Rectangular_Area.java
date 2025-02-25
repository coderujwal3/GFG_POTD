class Solution {
    public static int getMaxArea(int arr[]) {
        // your code here
        Stack <Integer> st = new Stack<>();
        int n = arr.length;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i <= n; i++) {
            int element = (i==n)? 0 : arr[i];
            while(!st.isEmpty() && arr[st.peek()] > element) {
                int h = arr[st.pop()];
                int ps = (st.isEmpty()) ? -1 : st.peek();
                int w = i - ps - 1;
                max = Math.max(max, h*w);
            }
            st.push(i);
        }
        return (max == Integer.MIN_VALUE)? 0 : max;
    }
}
