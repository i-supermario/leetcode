class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        List<Integer>[] nei = new List[numCourses];
        int[] ind = new int[numCourses];
        for(int[] pre: prerequisites){
            int course = pre[0];
            int dep = pre[1];
            ind[course]++;
            if(nei[dep]==null){
                nei[dep] = new ArrayList<>();
            }
            nei[dep].add(course);
        }

        Queue<Integer> q = new LinkedList<>();
        List<Integer> result = new ArrayList<>();

        for(int i=0;i<numCourses;i++){
            if(ind[i]==0) q.add(i);
        }

        while(!q.isEmpty()){
            int co = q.poll();
            result.add(co);
            if(nei[co]!=null){
                for(int c: nei[co]){
                    ind[c]--;
                    if(ind[c]==0) q.add(c);
                }
            }
        }

        return result.size() == numCourses;


    }
}