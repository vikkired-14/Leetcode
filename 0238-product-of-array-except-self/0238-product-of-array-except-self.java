class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] op = new int[nums.length];
        op[0]=1;
        for(int i=1;i<nums.length;i++){
            op[i] = op[i-1] * nums[i-1];
            System.out.println(op[i]);
        }
        int right =1 ;
        for(int i= nums.length-1;i>=0;i--){
            op[i] = right * op[i];
            right = nums[i]*right;
        }
        return op;
    }
}