class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {

        int[] curr = new int[3];
        for(int i=0;i<triplets.length;i++){

            if(triplets[i][0] <= target[0] && triplets[i][1] <= target[1] && triplets[i][2] <= target[2]){

                curr[0] = Math.max(curr[0], triplets[i][0]);
                curr[1] = Math.max(curr[1], triplets[i][1]);
                curr[2] = Math.max(curr[2], triplets[i][2]);

            }

        }

        return curr[0] == target[0] && curr[1] == target[1] && curr[2] == target[2];
        
    }
}