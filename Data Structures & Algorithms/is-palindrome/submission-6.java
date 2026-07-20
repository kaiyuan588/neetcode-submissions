class Solution {
    public boolean isPalindrome(String s) {
        if (s == null) {
            return false;
        } else if (s.length() == 0) {
            return true;
        }

        int left = 0;
        int right = s.length() - 1;

        while (left <= right) {
            while (left < s.length() && (!Character.isLetterOrDigit(s.charAt(left)) || s.charAt(left) == ' ')) {
                left++;
            }
            while (right >= 0 && (!Character.isLetterOrDigit(s.charAt(right)) || s.charAt(left) == ' ')) {
                right--;
            }
            if (left < s.length() && right >= 0 && Character.toUpperCase(s.charAt(left)) != Character.toUpperCase(s.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}
