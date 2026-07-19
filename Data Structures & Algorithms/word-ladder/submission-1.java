class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> words = new HashSet<>(wordList);
        if (!words.contains(endWord)) {
            return 0;
        }

        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        words.remove(beginWord);
        int len = 1;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String cur = q.poll();
                if (cur.equals(endWord)) {
                    return len;
                }
                char[] curArr = cur.toCharArray();

                for (int j = 0; j < curArr.length; j++) {
                    char tmpChar = curArr[j];
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        curArr[j] = ch;
                        String newStr = new String(curArr);
                        if (words.contains(newStr)) {
                            q.offer(newStr);
                            words.remove(newStr);
                        }
                    }
                    curArr[j] = tmpChar;
                }
            }
            len++;
        }
        return 0;
    }
}
