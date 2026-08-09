class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        Map<Character, Integer> window = new HashMap<>();
        Map<Character, Integer> curWindow = new HashMap<>();

        for (char c: s1.toCharArray()) {
            window.put(c, window.getOrDefault(c, 0) + 1);
        }

        int l = 0;
        for (int r = 0; r < s2.length(); r++) {
            if (r - l + 1 > s1.length()) {
                curWindow.put(s2.charAt(l), curWindow.getOrDefault(s2.charAt(l), 0) - 1);
                if (curWindow.get(s2.charAt(l)) == 0) {
                    curWindow.remove(s2.charAt(l));
                } 
                l++;
            } 
            curWindow.put(s2.charAt(r), curWindow.getOrDefault(s2.charAt(r), 0) + 1);
            if (curWindow.size() == window.size()) {
                int formedCount = 0;
                for (Map.Entry<Character, Integer> entry: window.entrySet()) {
                    if (curWindow.containsKey(entry.getKey()) && curWindow.get(entry.getKey()) == entry.getValue()) {
                        formedCount++;
                    } else {
                        break;
                    }
                }
                if (formedCount == window.size()) {
                    return true;
                }
            }
        }

        return false;
    }
}
