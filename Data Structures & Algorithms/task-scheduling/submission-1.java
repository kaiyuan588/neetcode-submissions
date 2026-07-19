class Solution {
    public int leastInterval(char[] tasks, int n) {
        if (tasks == null || tasks.length == 0) {
            return 0;
        }
        Map<Character, Integer> countMap = new HashMap<>();
        for (char c: tasks) {
            countMap.put(c, countMap.getOrDefault(c, 0) + 1);
        }
        PriorityQueue<Node> maxHeap = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node n1, Node n2) {
                if (n1.count > n2.count) return -1;
                return n1.count < n2.count ? 1 : 0;
            }
        });

        for (Map.Entry<Character, Integer> entry: countMap.entrySet()) {
            maxHeap.offer(new Node(entry.getKey(), entry.getValue(), 0));
        }
        Queue<Node> cooldown = new LinkedList<>();
        
        int curTime = 0;
        int res = 0; 
        // 1️⃣ 先看看有没有任务 冷却结束 → 可以重新执行
        // 2️⃣ 如果有可执行任务 → 选剩余次数最多的执行
        // 3️⃣ 如果没有 → CPU idle
        // 4️⃣ 时间 +1
        while (!maxHeap.isEmpty() || !cooldown.isEmpty()) {
            // 1. check cool down, insert all cooldown ready node into heap
            while (!cooldown.isEmpty() && cooldown.peek().readyTime <= curTime) {
                maxHeap.offer(cooldown.poll());
            }

            // 2. get the max freq node and process
            if (!maxHeap.isEmpty()) {
                Node curNode = maxHeap.poll();
                curNode.count--;
                if (curNode.count > 0) {
                    curNode.readyTime = curTime + n + 1;
                    cooldown.offer(curNode);
                }
            }
            curTime++;
            res++;
        }
        return res;
    }

    class Node {
        char name;
        int count;
        int readyTime;

        public Node(char name, int count, int readyTime) {
            this.name = name;
            this.count = count;
            this.readyTime = readyTime;
        }
    }
}
