class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int[] op = new int[n];
        op[n-1]=0;
        for(int i=n-2;i>=0;i--){
            op[i] = op[i+1]+nums[i+1];
            // System.out.println(i + "->" + op[i]);
        }
        int left =0 ;
        for(int i= 0;i<n;i++){
            if(left==op[i])
              return i;
            left += nums[i];  
        }

        return -1;
    }
}