class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        int[] map = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            map[s1.charAt(i)-'a']++;
        }

        int left = 0; 
        int right = 0;
        
        while (right < s2.length()) {
            int dis = right - left + 1;
            if (dis <= s1.length()) {
                // update first
                map[s2.charAt(right)-'a']--;
                right++;
                // find the res
                if (dis == s1.length() && isValid(map)) {
                    return true;
                }
            } else {
                map[s2.charAt(left)-'a']++;
                left++;
            }
        }
        return false;
    }
    public boolean isValid(int[] map) {
        for (int i: map) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }
}
