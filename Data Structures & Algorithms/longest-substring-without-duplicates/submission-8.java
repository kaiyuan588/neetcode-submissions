class Solution {
    public int lengthOfLongestSubstring(String s) {
        int len = 0;
        Set<Character> set = new HashSet<>();
        int left = 0;
        int right = 0;

        while (right < s.length()) {
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            } 
            len = Math.max(right - left + 1, len);
            set.add(s.charAt(right));
            right++;
            
        }
        return len;
    }
}
