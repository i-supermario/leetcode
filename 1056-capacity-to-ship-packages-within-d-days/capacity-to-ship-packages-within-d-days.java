class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int max = 0;
        int total = 0;
        for(int w: weights){
            max = Math.max(max,w);
            total += w;
        }

        int low = max;
        int high = total;
        int mid = 1;
        while(low < high){
            mid = low + (high - low) / 2;
            int currDays = timeToShipWithKCapacity(weights, mid);
            if(currDays > days){
                low = mid + 1;
            }
            else high = mid;
        }

        return low;

        
    }

    int timeToShipWithKCapacity(int[] weights, int capacity){

        int days = 0;
        int currWeight = 0;
        for(int w: weights){
            currWeight += w;
            if(currWeight == capacity){
                days++;
                currWeight = 0;
            }
            if(currWeight > capacity){
                days++;
                currWeight = w;
            }
        }
        if(currWeight != 0) days++;

        return days;


    }
}