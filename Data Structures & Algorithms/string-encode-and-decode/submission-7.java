class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String s: strs) {
            int len = s.length();
            sb.append(len);
            sb.append('#');
            sb.append(s);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();

        int i = 0;

        while (i < str.length()) {
            int len = -1;
            while (Character.isDigit(str.charAt(i))) {
                if (len == -1) {
                    len = str.charAt(i) - '0';
                } else {
                    len = len * 10;
                    len += str.charAt(i) - '0';
                }
                i++;
            }

            // int len = 0;

            // while (str.charAt(i) != '#') {
            //     len = len * 10 + (str.charAt(i) - '0');
            //     i++;
            // }
            res.add(str.substring(i+1, i+1+len));
            i = i + 1 + len;
        }
        return res;
    }
}
