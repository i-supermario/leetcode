class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {

        /*

        check if total % k == 0
        target = total / k;
        sort descending ?
        used[]

        - build each partition
        - keep track of number of partitions built
        - current partition sum

        [1, 2, 3] k = 2
        Time complexity => O(2 ^ n) where n is nums length
        Space complexity => O(2 ^ n * n) stack space

        */

        Arrays.sort(nums);
        int[] newNums = new int[nums.length];
        // reverse
        int m = nums.length;
        int total = 0;

        for(int i=0;i<m;i++){
            total += nums[i];
            newNums[m - i - 1] = nums[i];
        }

        if(total % k != 0) return false;
        if (newNums[0]*k > total) return false;

        return backtrack(newNums, total / k, 0,  new int[k]);


    }

    boolean backtrack(int[] nums,int targetSum, int idx, int[] buckets){
        if(idx == nums.length) return true;
        for(int i=0;i<buckets.length; i++){
            if(buckets[i] + nums[idx] <= targetSum){

                buckets[i] += nums[idx];
                if(backtrack(nums, targetSum, idx + 1, buckets)) return true;
                buckets[i] -= nums[idx];

            }
            if(buckets[i] == 0) break;

        }

        return false;

    }
}