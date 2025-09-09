class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new ArrayList<>();
        backTrack(candidates,0,0,target,new ArrayList<>());
        return res;
    }
    
    public void  backTrack(int[] candidates,int start,int sum,int target,List<Integer> path){
        if(sum> target)
          return;
        if(target==sum)
         res.add(new ArrayList<>(path));
       
        for(int i=start;i<candidates.length;i++){
          path.add(candidates[i]);
          backTrack(candidates,i,sum +candidates[i], target,path);
          path.remove(path.size()-1);  
        }
    }

}