static boolean isBalanced(String s) {
    // code here
    Map<Character,Character> hm = new HashMap<>();
    hm.put(')','(');
    hm.put(']', '[');
    hm.put('}', '{');
    Stack<Character> st = new Stack<>();
    for(int i = 0; i < s.length(); i++) {
        char c = s.charAt(i);
        if(c=='(' || c=='[' || c=='{')st.push(c);
        else if(st.empty())return false;
        else {
            if(st.peek()!=hm.get(c))return false;
            st.pop();
        }
    }
    return st.empty();
}
