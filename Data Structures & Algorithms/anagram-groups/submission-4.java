class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> group = new HashMap<>();

        for (String s: strs) {
            int[] key = new int[26];

            for (char c: s.toCharArray()) {
                key[c-'a']++;
            }
            String k = Arrays.toString(key);
            if (!group.containsKey(k)) {
                group.put(k, new ArrayList<>());
            }
            group.get(k).add(s);
        }
        List<List<String>> res = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry: group.entrySet()) {
            res.add(entry.getValue());
        }

        return res;
    }
}
