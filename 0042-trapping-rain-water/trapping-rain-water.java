class Solution {
    public int trap(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int leftH = 0;
        int rightH = 0;
        int volume = 0;
        while(i < j){

            if(height[i] < height[j]){

                if(height[i] < leftH){
                    volume += leftH - height[i];
                }
                else leftH = Math.max(leftH, height[i]);
                i++;
            }
            else{
                if(height[j] < rightH){
                    volume += rightH - height[j];
                }
                else rightH = Math.max(rightH, height[j]);
                j--;
            }

        }

        return volume;
        
    }
}