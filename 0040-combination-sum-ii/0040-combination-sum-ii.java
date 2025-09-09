class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res = new ArrayList<>();
        Arrays.sort(candidates);
        backTrack(candidates,0,target,new ArrayList<>());
        return res;
    }

    public void backTrack(int[] candidates,int start,int target,List<Integer> path){
        if(target==0)
          {
            res.add(new ArrayList<>(path));
            return;
          }
          for(int i= start;i<candidates.length;i++){
            if (i > start && candidates[i] == candidates[i-1]) continue;
            if(candidates[i]>target) break;
            path.add(candidates[i]);
            backTrack(candidates,i+1,target-candidates[i],path);
            path.remove(path.size()-1);
          }
    }
}