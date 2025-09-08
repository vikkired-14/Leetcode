class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        if(nums1.length>nums2.length)
          return findMedianSortedArrays(nums2,nums1);

        int m = nums1.length;
        int n = nums2.length;
        int half = (m+n+1)/2;
        int left=0;
        int right= m;
        while(left<=right){
            int i = (left+right)/2;
            int j = half -i;
            int num1Left = (i==0)? Integer.MIN_VALUE: nums1[i-1];
            int num1right = (i==m)? Integer.MAX_VALUE: nums1[i];
            int num2Left = (j==0)? Integer.MIN_VALUE: nums2[j-1];
            int num2right = (j==n)? Integer.MAX_VALUE: nums2[j]; 
            if(num1Left<=num2right && num2Left<=num1right){
                if((m+n)%2==0)
                  return (Math.max(num1Left,num2Left) + Math.min(num1right,num2right))/2.0;
                else
                   return Math.max(num1Left,num2Left);  
            }else if(num1Left>num2right){
                right = i -1;
            }else{
                left = i+1;
            }
        }
       return -1;
    }
}