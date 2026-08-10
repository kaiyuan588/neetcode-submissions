class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> count = new HashMap<>();

        for (char c: tasks) {
            count.put(c, count.getOrDefault(c, 0)+ 1);
        }

        PriorityQueue<Character> maxHeap = new PriorityQueue<>(new Comparator<Character>(){
            @Override
            public int compare(Character c1, Character c2) {
                if (count.get(c1) > count.get(c2)) {
                    return -1;
                }
                return count.get(c1) < count.get(c2) ? 1 : 0;
            }
        });
        Queue<CoolDown> coolDown = new LinkedList<>(); // freq, next on time

        for (Map.Entry<Character, Integer> entry: count.entrySet()) {
            maxHeap.offer(entry.getKey());
        }
        int res = 0;
        int time = 0;

        while (true) {
            if (!coolDown.isEmpty() && coolDown.peek().onTime == time) {
                CoolDown processTask = coolDown.poll();
                count.put(processTask.task, processTask.freq);
                maxHeap.offer(processTask.task);
            }
            if (!maxHeap.isEmpty()) {
                char cur = maxHeap.poll();
                int freq = count.get(cur)-1;
                if (freq > 0) {
                    count.put(cur, freq);
                    coolDown.offer(new CoolDown(cur, freq, time + n + 1));
                } else {
                    count.remove(cur);
                }
            }
            time++;
            if (maxHeap.isEmpty() && coolDown.isEmpty()) {
                break;
            }
        }
        return time;
    }

    class CoolDown {
        char task;
        int freq;
        int onTime;
        public CoolDown(char task, int freq, int onTime) {
            this.task = task;
            this.freq = freq;
            this.onTime = onTime;
        }
    }
}


