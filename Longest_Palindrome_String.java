class Solution {
    // EAC = Expand Arround Center
    static String EAC(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return s.substring(left + 1, right);
    }
    static String longestPalindrome(String s) {
        // code here
        if (s == null || s.length() == 0) return "";
        
        String LP = "";
        for (int i = 0; i < s.length(); i++) {
            String pal1 = EAC(s, i, i);
            if (pal1.length() > LP.length()) LP = pal1;
            
            String pal2 = EAC(s, i, i + 1);
            if (pal2.length() > LP.length()) LP = pal2;
        }
        
        return LP;
    }
}
