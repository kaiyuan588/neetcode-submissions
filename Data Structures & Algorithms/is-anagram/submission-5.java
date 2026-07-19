class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        Map<Character, Integer> sm = new HashMap<>();
        Map<Character, Integer> tm = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            sm.put(s.charAt(i), sm.getOrDefault(s.charAt(i), 0) + 1);
            tm.put(t.charAt(i), tm.getOrDefault(t.charAt(i), 0) + 1);
        }
        
        for (char ch: t.toCharArray()) {
            if (!sm.containsKey(ch) || !tm.containsKey(ch) || sm.get(ch).intValue() != tm.get(ch).intValue()) {
                return false;
            } 
        }
        return true;
    }
}
