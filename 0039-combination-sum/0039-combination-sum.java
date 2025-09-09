class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new ArrayList<>();
        Arrays.sort(candidates);             
        backTrack(candidates,0,target,new ArrayList<>());
        return res;
    }
    
    public void  backTrack(int[] candidates,int start,int target,List<Integer> path){
        if(target==0){
         res.add(new ArrayList<>(path));
         return;
        }
         
       
        for(int i=start;i<candidates.length;i++){
            if(candidates[i]> target) break;
          path.add(candidates[i]);
          backTrack(candidates,i, target-candidates[i],path);
          path.remove(path.size()-1);  
        }
    }

}