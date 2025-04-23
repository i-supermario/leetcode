class Solution {
    public int minSubArrayLen(int target, int[] nums) {

        int left = 0;
        int windowLength = Integer.MAX_VALUE;
        for(int right = 0;right < nums.length;right++){
            target -= nums[right];
            
            while(target <= 0){
                windowLength = Math.min(windowLength, right - left + 1);
                target += nums[left];
                left++;
            }
        }

        return windowLength == Integer.MAX_VALUE ? 0 : windowLength;
        
    }
}