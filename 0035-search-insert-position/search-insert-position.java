class Solution {
    public int searchInsert(int[] nums, int target) {

        int low = 0;
        int high = nums.length - 1;

        int mid = -1;
        while(low < high){
            mid = (low + high)/2;
            if(target <= nums[mid]) high = mid;
            else low = mid + 1;

            if(nums[mid] == target) return mid;
        }

        if(nums[low] == target) return low;

        return target < nums[low] ? low : low + 1;
        
    }
}