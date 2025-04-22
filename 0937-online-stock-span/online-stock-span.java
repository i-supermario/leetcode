class StockSpanner {

    List<Integer> history;
    Stack<Integer> st;

    public StockSpanner() {
        history = new ArrayList<>();
    }
    
    public int next(int price) {
        int i = history.size() - 1;
        while(i >= 0 && price >= history.get(i)) i--;
        history.add(price);
        return history.size() - i - 1;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */