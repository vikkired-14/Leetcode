class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        backTrack(nums,used,new ArrayList<>());
        return res;
    }

    public void backTrack(int[] nums,boolean[] used,List<Integer> path){

     if(path.size()==nums.length){
       res.add(new ArrayList<>(path));
       return;
     }
     
     for(int i= 0;i<nums.length;i++){
        if(used[i]) continue;
        used[i] = true;
        path.add(nums[i]);
        backTrack(nums,used,path);
        path.remove(path.size()-1);
        used[i] = false;
     } 
    }
}