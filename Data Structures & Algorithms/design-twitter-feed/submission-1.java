class Twitter {
    Map<Integer, Set<Integer>> followMap;
    Map<Integer, Tweet> tweetMap;
    int time;

    public Twitter() {
        followMap = new HashMap<>();
        tweetMap = new HashMap<>();
        time = 0;

    }
    
    public void postTweet(int userId, int tweetId) {
        follow(userId, userId);
        Tweet tweet = new Tweet(tweetId, time);
        if (!tweetMap.containsKey(userId)) {
            tweet.prev = null;
            tweetMap.put(userId, tweet);
        } else {
            tweet.prev = tweetMap.get(userId);
            tweetMap.put(userId, tweet);
        }
        time++;
    }
    
    public List<Integer> getNewsFeed(int userId) {
        Set<Integer> followees = followMap.get(userId);
        List<Integer> res = new ArrayList<>();

        PriorityQueue<Tweet> maxHeap = new PriorityQueue<>(new Comparator<>() {
            @Override
            public int compare(Tweet t1, Tweet t2) {
                if (t1.time > t2.time) {
                    return -1;
                }
                return t1.time < t2.time ? 1 : 0;
            }
        });
        for (int i: followees) {
            Tweet tweet = tweetMap.get(i);
            maxHeap.offer(tweet);
        }
        int k = 0;
        while (k < 10 && !maxHeap.isEmpty()) {
            Tweet cur = maxHeap.poll();
            res.add(cur.tweetId);
            cur = cur.prev;
            if (cur != null) {
                maxHeap.offer(cur);
            }
            k++;
        }
        return res;
    }
    
    // [1 2 3]
    // [4 5 6]
    // [3 4 5 7]
    public void follow(int followerId, int followeeId) {
        if (!followMap.containsKey(followerId)) {
            followMap.put(followerId, new HashSet<>());
        }
        followMap.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (followerId == followeeId) return ;
        if (!followMap.containsKey(followerId)) {
            return ;
        }
        followMap.get(followerId).remove(followeeId);
    }

    class Tweet {
        int tweetId;
        int time;
        Tweet prev;
        public Tweet(int tweetId, int time) {
            this.tweetId = tweetId;
            this.time = time;
        }
    }
}

// userId
// feeds [tweetId..]

// follows [other users userId..]


// follow 
// userId : Set<UserId> initilize with [userId]

// unfollow
// remove the userId in the set


// publish
// for each tweetId we need a time var
// userId: [(tweetId,time) ..]

// getNewsFeed

