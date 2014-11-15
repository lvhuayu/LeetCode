/* At first, I use queue to keep track of the order of key that be recently used 
 * But the result is Time Limit Exceeded. Because it takes O(n) to remove an element in the Queue
 * We need to find a way that can uses O(1) time to delete an element in the Queue
 * So here, we use the doubly-LinkedList
 * Another important thing is we need keep key in the Node, which is used to delete the key-pair from hashmap
 */
 
public class LRUCache {
    private class Node {
        int key;
        int value;
        Node prev;
        Node next;
        
        private Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.prev = null;
            this.next = null;
        }
    }
    // use hashmap to store the key-value pair
    private Map<Integer, Node> map = new HashMap<Integer, Node>();
    private Node head = new Node(-1, -1);
    private Node tail = new Node(-1, -1);
    // use to represent the capacity of the queue
    private int capacity;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        
        // remove current
        Node current = map.get(key);
        current.prev.next = current.next;
        current.next.prev = current.prev;
        
        // move current to tail
        move_to_tail(current);
        
        return current.value;
    }
    
    public void set(int key, int value) {
        if (get(key) != -1) {
            map.get(key).value = value;
            return;
        }
        
        if (map.size() == capacity) {
            map.remove(head.next.key);
            head.next = head.next.next;
            head.next.prev = head;
        }
        
        Node insertNode = new Node(key, value);
        map.put(key, insertNode);
        move_to_tail(insertNode);
    }
    
    private void move_to_tail(Node current) {
        current.prev = tail.prev;
        current.prev.next = current;
        current.next = tail;
        tail.prev = current;
    }
}