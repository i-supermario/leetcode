class Solution {
    public int[] productExceptSelf(int[] nums) {

        int[] post = new int[nums.length+1];
        int[] pre = new int[nums.length+1];
        pre[0] = 1;
        post[nums.length - 1] = 1;
        for(int i=0;i<nums.length-1;i++){
            pre[i+1] = pre[i] * nums[i];
            
        }
        for(int i=nums.length - 1;i>0;i--){
            post[i-1] = post[i] * nums[i];
            
        }

        int[] result = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            result[i] = pre[i] * post[i];
        }
        return result;
        
    }
}