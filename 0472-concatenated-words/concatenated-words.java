class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {

        Arrays.sort(words, (a,b) -> a.length() - b.length());
        Set<String> wordSet = new HashSet<>();

        List<String> result = new ArrayList<>();


        for(String s: words){
            if(backtrack(s,wordSet,result)){
                result.add(s);
            }
            wordSet.add(s);
        
        }

        return result;
        
    }

    private boolean backtrack(String temp, Set<String> wordSet,List<String> result){
        
        boolean[] dp = new boolean[temp.length()+1];

        dp[0] = true;
        for(int i=1;i<=temp.length();i++){
            for(int j=0;j<i;j++){

                if(dp[j] && wordSet.contains(temp.substring(j,i))){
                    dp[i] = true;
                }
            }
        }


        return dp[temp.length()];

    }
}