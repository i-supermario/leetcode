class Solution {
    public List<Integer> partitionLabels(String s) {

        Map<Character, Integer> all = new HashMap<>();
        Map<Character, Integer> tracker = new HashMap<>();

        for(char ch: s.toCharArray()){
            all.put(ch, all.getOrDefault(ch,0)+1);
        }

        int noOfUniqueChars = all.size();
        List<Integer> result = new ArrayList<>();
        int start = 0;

        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            tracker.put(ch, tracker.getOrDefault(ch,0)+1);
            int currCount = all.get(ch);
            if(currCount - 1 == 0) all.remove(ch);
            else all.put(ch, all.get(ch) - 1);
            if(tracker.size() + all.size() == noOfUniqueChars){
                result.add(i - start + 1);
                start = i + 1;
            }

        }

        return result;


        
    }
}