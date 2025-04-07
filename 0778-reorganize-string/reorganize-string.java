class Solution {
    public String reorganizeString(String s) {

        int[] letters = new int[26];
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b) -> b[1] - a[1]);

        for(char ch: s.toCharArray()) letters[ch - 'a']++;
        for(int i=0;i<26;i++){
            if(letters[i] != 0){
                q.offer(new int[]{i,letters[i]});
            }
        }

        StringBuilder sb = new StringBuilder();

        while(q.size() > 1){

            int[] first = q.poll();
            int[] second = q.poll();
            

            sb.append((char)(first[0] + 'a'));
            sb.append((char)(second[0] + 'a'));

            first[1]--;
            second[1]--;
            if(first[1] > 0) q.offer(first);
            if(second[1] > 0) q.offer(second);

        }

        if(q.size() > 0){

            int curr[] = q.poll();

            if(curr[1] > 1) return "";

            int i = 0;

            while(i < curr[1]){
                sb.append((char)(curr[0] + 'a'));
                i++;
            }

        }

        return sb.toString();
        
    }
}