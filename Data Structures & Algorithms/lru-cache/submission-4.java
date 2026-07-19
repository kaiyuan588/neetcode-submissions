class LRUCache {
    DoubleLinkedList left; // least recent use
    DoubleLinkedList right; // most recent use
    Map<Integer, DoubleLinkedList> map;
    int capacity;
    int currSize;
    public LRUCache(int capacity) {
        this.left = new DoubleLinkedList(-1,-1);
        this.right = new DoubleLinkedList(-1,-1);
        left.next = right;
        right.prev = left;

        this.map = new HashMap<>();
        this.capacity = capacity;
        this.currSize = 0;
    }
    
    public int get(int key) {
        // return the key if exist
        if (map.containsKey(key)) {
            DoubleLinkedList node = map.get(key);
            // update double linked list, move the key to the right
            moveToMostRecent(node);
            return node.val;
        } else {
            return -1;
        }
    }
    public void insertToMostRecent(DoubleLinkedList node) {
        DoubleLinkedList oldMostRecent = right.prev;
        oldMostRecent.next = node;
        node.prev = oldMostRecent;
        node.next = right;
        right.prev = node; 
    }
    public void moveToMostRecent(DoubleLinkedList node) {
        removeNode(node);
        insertToMostRecent(node);
    }

    public void put(int key, int value) {
        // if key exist
        if (map.containsKey(key)) {
            DoubleLinkedList node = map.get(key);
            node.val = value;
            // update to the most recent
            moveToMostRecent(node);
            map.put(key, node);
        } else {
            // if key doesn't exist, add to the linkedlist
            // 1. If we have enough capacity
            DoubleLinkedList newNode = new DoubleLinkedList(key, value);
            if (currSize < capacity) {
                map.put(key, newNode);
                insertToMostRecent(newNode);
                currSize++;
            } else {
            //2. If we do NOT have enough capacity, remove the least recently used key
                DoubleLinkedList leastRecent = left.next;
                removeNode(leastRecent);
                map.remove(leastRecent.key);
                insertToMostRecent(newNode);
                map.put(key, newNode);
            }
        }
    }

    public void removeNode(DoubleLinkedList node) {
        DoubleLinkedList prevNode = node.prev;
        DoubleLinkedList nextNode = node.next;

        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }

    class DoubleLinkedList {
        int key;
        int val;
        DoubleLinkedList prev;
        DoubleLinkedList next;

        public DoubleLinkedList(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
}

// get, return the value of the key if exist, else return -1
// put update the value of the key if key exists, else add the key-value pair into cache
// if the capacity exceed capacity, remove the least recent used key

// need a double linked list, if the size exceeds capacity, remove the front of the linkedlist
// hashmap stores the key value pair, while removing the linkedlist, remove the key from the hashMap