class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {

        Set<Integer> set = new HashSet<>();
        for(int right = 0; right < nums.length; right++){
            if(right > k) set.remove(nums[right - k - 1]);
            if(set.contains(nums[right])) return true;
            set.add(nums[right]);
        }
        return false;
        
    }
}