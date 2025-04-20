class Solution {
    public int maxProfit(int[] prices) {
        
        Stack<Integer> st = new Stack<>();
        int profit = 0;

        for(int p: prices){
            if(!st.isEmpty() && p > st.peek()){
                profit += p - st.pop();
            }
            st.push(p);
        }

        return profit;

    }
}