class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            if(i==0 ||nums[i]!=nums[i-1]){
                twoSum(i,nums,res);
            }
        }
        return res;
    }

    public void twoSum(int i,int[] nums,List<List<Integer>> res){
      var seen = new HashSet<Integer>();
      for(int j=i+1;j<nums.length;j++){
        int target = -nums[i]-nums[j];
        if(seen.contains(target)){
            res.add(List.of(nums[i],nums[j],target));
            while(j+1<nums.length && nums[j]==nums[j+1]) j++;
        }
        seen.add(nums[j]);
      }
    }
}