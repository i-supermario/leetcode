class Solution {
    public int removeDuplicates(int[] nums) {
        int j = 0;
        for(int i=0;i<nums.length;i++){
            nums[j++] = nums[i];
            while(i < nums.length - 1 && nums[i] == nums[i+1]) i++;
        }

        return j;

        
        
    }
}