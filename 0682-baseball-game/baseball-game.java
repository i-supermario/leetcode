class Solution {
    public int calPoints(String[] operations) {
        
        Stack<Integer> st = new Stack<>();
        for(String op: operations){

            if(op.equals("+")){
                int s1 = st.pop();
                int s2 = st.peek();
                st.push(s1);
                st.push(s1 + s2);
            }
            else if(op.equals("D")){
                st.push(st.peek() * 2);
            }
            else if(op.equals("C")) st.pop();
            else st.push(Integer.parseInt(op));

        }

        int total = 0;
        while(!st.isEmpty()) total += st.pop();
        return total;

    }
}