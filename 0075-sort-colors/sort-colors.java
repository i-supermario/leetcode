class Solution {
    public void sortColors(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();
        for(int num: nums){
            map.putIfAbsent(num,0);
            map.put(num,map.get(num)+1);
        }
        int start = 0;
        for(int i=0;i<3;i++){

            int count = map.getOrDefault(i,0);
            int end = start + count;
            while(start < end){
                nums[start] = i;
                start++;
            }

        }

        return;


        
    }
}