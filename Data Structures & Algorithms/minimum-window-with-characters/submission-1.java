class Solution {
    public String minWindow(String s, String t) {
        // every char inside t exits in s
        // Step
        // maintain a window with char count of t
        // looping through s, if s exits in the map, count--, if count == 0, formed++
        // when formed == map.size(), then cal the result
        // while formed == map.size, shirnk the left side and cal the reuslt

        if (s == null || t == null) return "";
        int m = s.length();
        int n = t.length();
        if (n > m) return "";


        Map<Character, Integer> tMap = new HashMap<>();
        for (char c: t.toCharArray()) {
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }

        int formed = 0;
        int left = 0;
        int shortest = Integer.MAX_VALUE;
        String res = "";
        for (int right = 0; right < m; right++) {
            char rightChar = s.charAt(right);
            if (tMap.containsKey(rightChar)) {
                tMap.put(rightChar, tMap.get(rightChar)-1);
                if (tMap.get(rightChar) == 0) {
                    formed++;
                }
            }
            
            while (formed == tMap.size()) {
                if (right - left + 1 < shortest) {
                    shortest = right - left + 1;
                    res = s.substring(left, right+1);
                }
                char leftChar = s.charAt(left);
                if (tMap.containsKey(leftChar)) {
                    tMap.put(leftChar, tMap.get(leftChar)+1);
                    if (tMap.get(leftChar) == 1) {
                        formed--;
                    }
                }
                left++;
            }
        }
        return res;
    }
}
