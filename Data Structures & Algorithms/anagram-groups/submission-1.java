class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String s: strs) {
            int[] count = new int[26];
            for (char ch: s.toCharArray()) {
                count[ch - 'a']++;
            }
            String key = Arrays.toString(count);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(s);
        }
        List<List<String>> res = new ArrayList<>();

        for (List<String> list: map.values()) {
            res.add(list);
        }
        return res;
    }
}
