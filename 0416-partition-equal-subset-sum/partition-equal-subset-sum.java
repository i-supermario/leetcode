class Solution {
    public boolean canPartition(int[] nums) {

        int total = 0;
        for(int num: nums) total += num;
        if(total % 2 != 0) return false;
        
        boolean[] dp = new boolean[(total/2) + 1];
        dp[0] = true;

        for(int num: nums){

            for(int i=total/2;i>=1;i--){

                if( i - num >= 0 ){
                    dp[i] |= dp[i - num]; 
                }

            }
        }

        return dp[total/2];
        
    }
}