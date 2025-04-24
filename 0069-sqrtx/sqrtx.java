class Solution {
    public int mySqrt(int x) {
        if(x <= 1) return x;
        int low = 1;
        int high = x / 2;
        int mid = 1;
        while(low <= high){
            mid = low + (high - low) / 2;
            if(mid*mid == x){
                return mid;
            }
            else if( (long) mid*mid < (long) x) low = mid + 1;
            else high = mid - 1;
        }

        return Math.round(high);
        
        

    }
}