class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] topology = new int[numCourses];
        Map<Integer,List<Integer>> courseMap = new HashMap<>();
        for(int[] preq: prerequisites){
            int course = preq[0];
            int preReq = preq[1];
           courseMap.putIfAbsent(preReq,new ArrayList<>()); 
           courseMap.get(preReq).add(course);
           topology[course]++;
        }
        int count=0;
        Queue<Integer> qu = new LinkedList<Integer>();
        for(int i=0;i<numCourses;i++){
            if(topology[i]==0){
               qu.offer(i);
               count++;
            }
              
        }
        if(count==numCourses) return true;
        while(!qu.isEmpty()){
            int course = qu.poll();
            if(courseMap.containsKey(course)){
             for(Integer neigh : courseMap.get(course)){
                topology[neigh]--;
                if(topology[neigh]==0){
                    qu.offer(neigh);
                    count++;
                }
                if(count==numCourses) return true;
            }
        }
        }
        return false;
    }
}