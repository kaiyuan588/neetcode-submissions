class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        Map<Character, Integer> needWindow = new HashMap<>();
        Map<Character, Integer> curWindow = new HashMap<>();

        for (char c: s1.toCharArray()) {
            needWindow.put(c, needWindow.getOrDefault(c, 0) + 1);
        }

        int l = 0;
        for (int r = 0; r < s2.length(); r++) {
            curWindow.put(s2.charAt(r), curWindow.getOrDefault(s2.charAt(r), 0) + 1);
            if (r - l + 1 > s1.length()) {
                curWindow.put(s2.charAt(l), curWindow.get(s2.charAt(l)) - 1);
                if (curWindow.get(s2.charAt(l)) == 0) {
                    curWindow.remove(s2.charAt(l));
                }
                l++;
            } 
            if (curWindow.equals(needWindow)) {
                return true;
            }
        }

        return false;
    }
}
