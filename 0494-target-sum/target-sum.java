class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return helper(0,nums,target);
    }

    private int helper(int index,int[] nums, int target){
        if(index == nums.length ) return target == 0 ? 1 : 0;
        return helper(index + 1, nums, target - nums[index]) + helper(index + 1, nums, target + nums[index]);

    }
    
}