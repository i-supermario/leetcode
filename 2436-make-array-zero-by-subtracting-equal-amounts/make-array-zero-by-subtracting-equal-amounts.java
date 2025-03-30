class Solution {
    public int minimumOperations(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num: nums){
            if(num > 0 && !set.contains(num)) set.add(num);
        }

        return set.size();
    }
}