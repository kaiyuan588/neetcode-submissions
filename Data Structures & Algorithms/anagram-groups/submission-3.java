class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();

        Map<String, List<String>> map = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {
            int[] eachArr = new int[26];
            for (int j = 0; j < strs[i].length(); j++) {
                eachArr[strs[i].charAt(j) - 'a']++;
            }
            
            String eachStr = Arrays.toString(eachArr);
            if (!map.containsKey(eachStr)) {
                map.put(eachStr, new ArrayList<>());
            } 
            map.get(eachStr).add(strs[i]);

        }

        for (Map.Entry<String, List<String>> each: map.entrySet()) {
            res.add(each.getValue());
        }

        return res;
    }
}
