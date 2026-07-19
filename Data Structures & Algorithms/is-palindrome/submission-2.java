class Solution {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length()-1;

        while (left < right) {
            char l = Character.toLowerCase(s.charAt(left));
            char r = Character.toLowerCase(s.charAt(right));
            if (!isChar(l)) {
                left++;
            } else if (!isChar(r)) {
                right--;
            } else {
                if (l != r) {
                    return false;
                }
                left++;
                right--;
            }
        }
        return true;
    }
    public boolean isChar(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9');
    }
}
