class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return "";

        String res = "";
        int len = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (isPalin(s, i, j)) {
                    if (j - i + 1 > len) {
                        res = s.substring(i, j+1);
                        len = j - i + 1;
                    }
                }
            }
        }
        return res;
    }

    public boolean isPalin(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
