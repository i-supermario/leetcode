class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {

        if(hand.length % groupSize != 0) return false;

        Arrays.sort(hand);
        List<Integer> hands = new ArrayList<>();
        for(int n: hand) hands.add(n);

        while(hands.size() > 0){
            int curr = hands.remove(0);
            int end = curr + groupSize - 1;
            while(hands.size() != 0 && curr < end ){
                if(hands.contains(curr + 1)) hands.remove((Integer)(curr + 1));
                else return false;
                curr++;
            }

        }

        return true;
        
    }
}