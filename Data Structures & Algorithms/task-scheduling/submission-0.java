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

        while (!maxHeap.isEmpty() || !cooldown.isEmpty()) {
            // 1. check cool down, insert all cooldown ready node into heap
            while (!cooldown.isEmpty() && cooldown.peek().readyTime <= curTime) {
                Node curNode = cooldown.poll();
                // reset all ready time to 0
                maxHeap.offer(new Node(curNode.name, curNode.count, 0));
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
