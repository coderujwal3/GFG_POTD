class Solution {
    // Function to find the next greater element for each element of the array.
    public ArrayList<Integer> nextLargerElement(int[] arr) {
        // code here
        Stack<Integer> stk = new Stack();
        ArrayList<Integer> ans = new ArrayList<>(Collections.nCopies(arr.length, -1));
        for(int i = 0; i < arr.length; i++) {
            while(!stk.isEmpty() && arr[stk.peek()] < arr[i]) ans.set(stk.pop(), arr[i]);
            stk.push(i);
        }
        return ans;
    }
}
