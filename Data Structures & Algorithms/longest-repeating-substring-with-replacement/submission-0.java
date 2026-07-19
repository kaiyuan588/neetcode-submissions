class Solution {
    public int characterReplacement(String s, int k) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int[] map = new int[26];
        int res = 0;
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            map[s.charAt(right) - 'A']++;
            int mostFreq = getMostFreq(map);
            int curWindowSize = right - left + 1;

            while (curWindowSize - mostFreq > k) {
                map[s.charAt(left) - 'A']--;
                left++;
                curWindowSize = right - left + 1;
                mostFreq = getMostFreq(map);
            }

            if (curWindowSize - mostFreq <= k) {
                // valid
                res = Math.max(res, curWindowSize);
            }
        }
        return res;
    }
    
    public int getMostFreq(int[] map) {
        int res = 0;
        for (char c = 'A'; c <= 'Z'; c++) {
            res = Math.max(res, map[c - 'A']);
        }
        return res;
    }
}
