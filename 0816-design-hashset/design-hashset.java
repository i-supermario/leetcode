class MyHashSet {

    private List<Integer> set;

    public MyHashSet() {
        set = new ArrayList<>();
    }
    
    public void add(int key) {
        if(!contains(key)) set.add(key);
        return;
    }
    
    public void remove(int key) {
        set.remove((Integer)(key));
        return;
    }
    
    public boolean contains(int key) {
        return set.contains(key);
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */