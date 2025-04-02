class Solution {
    public int tupleSameProduct(int[] nums) {

        Map<Integer,Integer> map = new HashMap<>();

        int count = 0;

        for(int i=0;i<nums.length;i++){
            int num1 = nums[i];
            for(int j=i+1;j<nums.length;j++){
                int num2 = nums[j];
                map.putIfAbsent(num1*num2,-1);
                map.put(num1*num2,map.get(num1*num2)+1);
                count += map.get(num1*num2) * 8;

            }

        }

        return count;

        




        
    }
}