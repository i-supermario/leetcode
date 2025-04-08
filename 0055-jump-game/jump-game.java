class Solution {
    public boolean canJump(int[] nums) {
        if(nums.length <= 1) return true;
        boolean[] dp = new boolean[nums.length];
        dp[0] = true;

        for(int i=0;i<nums.length-1;i++){

            if(dp[i]){
                for(int j=i+1;j<=i+nums[i];j++){
                    if(j <= nums.length - 1){
                        dp[j] = true;
                    } 
                }
            }
            if(dp[nums.length-1]) return true;

        }

        return dp[nums.length -1];
        
    }
}