class Solution {
    public int maxArea(int[] height) {
      int left=0;
      int right = height.length-1;
      int maxArea =0;
      while(left<=right){
        maxArea = Math.max(maxArea,(right-left)*(Math.min(height[left],height[right])));
         if(height[left]<height[right]){
            left++;
        }else{
             right--;
        }
      } 
      return maxArea; 
    }
}