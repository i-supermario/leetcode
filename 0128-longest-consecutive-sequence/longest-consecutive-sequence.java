class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> s = new HashSet<>();
        for(int num: nums){
            s.add(num);
        }

        int count = 0;
        for(int num: nums){
            if(!s.contains(num)) continue;
            else s.remove(num);
            int left = num - 1;
            int right = num + 1;
            while(s.remove(left)) left--;
            while(s.remove(right)) right++;
            count = Math.max(count, right - left - 1);

        }

        return count;
        
    }
}