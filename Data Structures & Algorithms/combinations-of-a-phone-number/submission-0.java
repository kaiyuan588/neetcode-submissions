class Solution {
    public List<String> letterCombinations(String digits) {
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        
        List<String> input = new ArrayList<>();
        if (digits.length() == 0) return input;
        for (char s: digits.toCharArray()) {
            input.add(map.get(s));
        }
        List<String> res = new ArrayList<>();
        dfs(input, 0, new StringBuilder(), res);
        return res;
    }
    public void dfs(List<String> input, int index, StringBuilder path, List<String> res) {
        if (index == input.size()) {
            res.add(path.toString());
            return ;
        }
        String cur = input.get(index);
        for (char c: cur.toCharArray()) {
            path.append(c);
            dfs(input, index+1, path, res);
            path.deleteCharAt(path.length()-1);
        }
    }
}
