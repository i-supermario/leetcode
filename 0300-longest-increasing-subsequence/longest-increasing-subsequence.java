class Solution {
    public int lengthOfLIS(int[] nums) {
        int m = nums.length;
        int[] dp = new int[m];
        Arrays.fill(dp,1);

        for(int i=0;i<m;i++){
            for(int j=0;j<i;j++){
                if(nums[j] < nums[i]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
        }
        int highest = Integer.MIN_VALUE;
        for(int c: dp){
            highest = Math.max(highest, c);
        }

        return highest;

    }
}