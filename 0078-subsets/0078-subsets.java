class Solution {
     List<List<Integer>> res ;
    public List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<>();
        backTrack(nums,0,new ArrayList<>());
        return res;
    }

    public void backTrack(int[] nums,int start ,List<Integer> path){
        res.add(new ArrayList<>(path));
        for(int i= start;i<nums.length;i++){
            path.add(nums[i]);
            backTrack(nums,i+1,path);
            path.remove(path.size()-1); 
        }

    }
}