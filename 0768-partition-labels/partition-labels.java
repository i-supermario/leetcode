class Solution {
    public List<Integer> partitionLabels(String s) {

        int[] letters = new int[26];
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            letters[ch - 'a'] = i;
        }

        int start = 0, end = 0;
        List<Integer> result = new ArrayList<>();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            end = Math.max(end, letters[ch - 'a']);
            if(i == end){
                result.add(i - start + 1);
                start = i + 1;
            }

        }

        return result;


        
    }
}