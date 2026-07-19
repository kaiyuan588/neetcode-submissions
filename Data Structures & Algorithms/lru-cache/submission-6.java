class LRUCache {
    int capacity;
    int curSize;
    DoubleLinkedList left;
    DoubleLinkedList right;
    Map<Integer, DoubleLinkedList> map;

    public LRUCache(int capacity) { 
        this.capacity = capacity;
        this.curSize = 0;
        this.left = new DoubleLinkedList(-1, -1);
        this.right = new DoubleLinkedList(-1, -1);
        left.next = right;
        right.prev = left;
        this.map = new HashMap<>();
    }
    public int get(int key) { 
        if (map.containsKey(key)) {
            DoubleLinkedList node = map.get(key);
            moveToTheMostRecent(node);
            return node.val;
        } else {
            return -1;
        }
    }
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            DoubleLinkedList node = map.get(key);
            node.val = value;
            moveToTheMostRecent(node);
            map.put(key, node);
        } else {
            // doesn't exist
            if (curSize < capacity) {
                DoubleLinkedList newNode = new DoubleLinkedList(key, value);
                map.put(key, newNode);
                addToTheMostRecent(newNode);
                curSize++;
            } else {
                DoubleLinkedList leastRecent = left.next;
                removeNode(leastRecent);
                map.remove(leastRecent.key);

                DoubleLinkedList newNode = new DoubleLinkedList(key, value);
                addToTheMostRecent(newNode);
                map.put(key, newNode);
            }
        }
    }
    public void addToTheMostRecent(DoubleLinkedList node) {
        DoubleLinkedList mostRecent = right.prev;
        mostRecent.next = node;
        node.prev = mostRecent;
        
        node.next = right;
        right.prev = node;
    }
    public void moveToTheMostRecent(DoubleLinkedList node) {
        removeNode(node);
        addToTheMostRecent(node);
    }
    public void removeNode(DoubleLinkedList node) {
        DoubleLinkedList prevNode = node.prev;
        DoubleLinkedList nextNode = node.next;

        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }
    public class DoubleLinkedList {
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