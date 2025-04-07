class LRUCache {

    class Node{

        int key;
        int value;
        Node prev;
        Node next;

        Node(int k, int v){
            key = k;
            value = v;
        }


    }

    int size;
    Node oldest;
    Node latest;
    Map<Integer, Node> cache;

    public LRUCache(int capacity) {

        size = capacity;
        cache = new HashMap<>();
        oldest = new Node(0,0);
        latest = new Node(0,0);
        oldest.next = latest;
        latest.prev = oldest;
        
    }

    void remove(Node curr){

        
        Node prev = curr.prev;
        Node next = curr.next;
        prev.next = next;
        next.prev = prev;
        return;

    }

    void insert(Node curr){

        Node top = latest.prev;

        top.next = curr;
        curr.prev = top;

        latest.prev = curr;
        curr.next = latest;

    }
    
    public int get(int key) {

        if(!cache.containsKey(key)) return -1;
        Node curr = cache.get(key);
        remove(curr);
        insert(curr);
        return curr.value;

    }
    
    public void put(int key, int value) {

        Node curr = null;
        if(cache.containsKey(key)){

            curr = cache.get(key);
            remove(curr);

        }
        else{

            curr = new Node(key,value);

        }

        curr.value = value;
        insert(curr);
        cache.put(key,curr);


        if(cache.size() > size){

            cache.remove(oldest.next.key);
            remove(oldest.next);
            

        }

        return;

        
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */