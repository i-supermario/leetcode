class Solution {
    public List<Integer> majorityElement(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        for(int num: nums){
            count.put(num, count.getOrDefault(num,0)+1);
            if(count.get(num) > (nums.length/3) && !result.contains(num)) result.add(num);
        }

        return result;

    }
}