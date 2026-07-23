class Solution {
    public int characterReplacement(String s, int k) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Map<Character, Integer> window = new HashMap<>();

        int left = 0;
        int right = 0;

        int majorCount = 0;
        int res = 0;
        while (right < s.length()) {
            window.put(s.charAt(right), window.getOrDefault(s.charAt(right), 0) + 1);

            majorCount = Math.max(window.get(s.charAt(right)), majorCount);
            
            // right - left + 1 -> cur window len, cur window len - majorCount is the minor count
            while (right- left + 1 - majorCount > k) { 
                window.put(s.charAt(left), window.get(s.charAt(left)) - 1);
                left++;
            }

            res = Math.max(right - left + 1, res);
            right++;
        }

        return res;
    }
}