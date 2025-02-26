class Solution {
    public ArrayList<Integer> maxOfMins(int[] arr) {
        // Your code here
        int n = arr.length;
        ArrayList<Integer> result = new ArrayList<>(Collections.nCopies(n, 0));
        Stack<Integer> stack = new Stack<>();
        int[] left = new int[n];
        int[] right = new int[n];
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) stack.pop();
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        stack.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) stack.pop();
            right[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }
        int[] window = new int[n + 1];
        Arrays.fill(window, Integer.MIN_VALUE);
        for (int i = 0; i < n; i++) {
            int len = right[i] - left[i] - 1;
            window[len] = Math.max(window[len], arr[i]);
        }
        for (int i = n - 1; i >= 1; i--) window[i] = Math.max(window[i], window[i + 1]);
        for (int i = 1; i <= n; i++) result.set(i - 1, window[i]);
        
        return result;
    }
}
