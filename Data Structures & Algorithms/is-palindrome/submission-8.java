class Solution {
    public boolean isPalindrome(String s) {
        if (s == null) {
            return false;
        } else if (s.length() == 0) {
            return true;
        }

        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            while (left < right && (!Character.isLetterOrDigit(s.charAt(left)) || s.charAt(left) == ' ')) {
                left++;
            }
            while (left < right && (!Character.isLetterOrDigit(s.charAt(right)) || s.charAt(left) == ' ')) {
                right--;
            }
            if (Character.toUpperCase(s.charAt(left)) != Character.toUpperCase(s.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}
