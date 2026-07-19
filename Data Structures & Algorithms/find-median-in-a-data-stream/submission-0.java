class MedianFinder {
    PriorityQueue<Integer> small;
    PriorityQueue<Integer> large = new PriorityQueue<>();
    int count = 0;
    public MedianFinder() {
        small = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                if (a > b) return -1;
                return a < b ? 1 : 0;
            }
        });
    }
    
    public void addNum(int num) {
        // small heap size + 1 <= large heap size
        if (small.size() + 1 <= large.size()) {
            small.offer(num);
        } else {
            large.offer(num);
        }
        balance();
        count++;
    }
    
    public double findMedian() {
        if (count % 2 == 0) {
            return (double)(small.peek() + large.peek()) / 2;
        }
        return large.peek();
    }

    public void balance() {
        while (!small.isEmpty() && !large.isEmpty() && small.peek() > large.peek()) {
            int s = small.poll();
            int l = large.poll();
            large.offer(s);
            small.offer(l);
        }
    }
}

// 3 4 2 3

// small heap (max)


// large heap (min)
 