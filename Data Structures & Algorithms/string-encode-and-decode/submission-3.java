class Solution {
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            sb.append(s.length()).append('#').append(s);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        int i = 0;

        while (i < str.length()) {
            int j = i;
            while (str.charAt(j) != '#') j++;           // 找到分隔符 #
            int len = Integer.parseInt(str.substring(i, j));
            j++;                                        // 跳过 '#'
            res.add(str.substring(j, j + len));          // 读 len 个字符
            i = j + len;                                // 移动指针
        }

        return res;
    }
}
