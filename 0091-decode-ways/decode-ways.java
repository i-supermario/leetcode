class Solution {
    public int numDecodings(String s) {
        int[] dp = new int[s.length()+1];
        dp[0] = 1;
        for(int i=1;i<=s.length();i++){

            int curr = s.charAt(i-1) - '0';
            if(curr >= 1 && curr <= 9 ){
                dp[i] += dp[i-1];
            }
            if( i - 2 >= 0 && s.charAt(i-2) != '0'){

                curr = Integer.parseInt(s.substring(i-2,i));
                if(curr >= 10 && curr <= 26 ){

                    dp[i] += dp[i-2];

                }

            }

        }

        return dp[s.length()];

    }
}