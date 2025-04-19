class Solution {
    public int majorityElement(int[] nums) {

        int maxFreq = 0;
        int maxNum = 0;
        Map<Integer, Integer> count = new HashMap<>();
        for(int num: nums){

            count.put(num,count.getOrDefault(num, 0) + 1);
            if(count.get(num) > maxFreq){
                maxNum = num;
                maxFreq = count.get(num);
            }
        }

        return maxNum;
        
        
    }
}