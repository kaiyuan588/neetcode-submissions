class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return "";

        String res = "";
        int len = 0;

        for (int i = 0; i < s.length(); i++) {
            // odd palin
            int l = i;
            int r = i;
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                if (r - l + 1 > len) {
                    len = r - l + 1;
                    res = s.substring(l, r+1);
                }
                l--;
                r++;
            }

            // even palin
            l = i;
            r = i+1;
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                if (r - l + 1 > len) {
                    len = r - l + 1;
                    res = s.substring(l, r+1);
                }
                l--;
                r++;
            }
        }
        return res;
    }


}
