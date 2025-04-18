class Solution {
    public String longestCommonPrefix(String[] strs) {

        Arrays.sort(strs);

        String shortWord = strs[0];
        String longWord = strs[strs.length - 1];

        int i=0;
        while(i < Math.min(shortWord.length(), longWord.length()) && shortWord.charAt(i) == longWord.charAt(i)) i++;

        return shortWord.substring(0,i);
        
    }
}