class Solution {
    public int countPS(String s) {
        // code here
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            count += EAC(s, i, i);      // EAC = Expand Arround Center
            count += EAC(s, i, i + 1);
        }
        return count;
    }
    
    public int EAC(String s, int left, int right) {
        int count = 0;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            if (right - left + 1 >= 2) count++;
            left--;
            right++;
        }
        return count;
    }
}
