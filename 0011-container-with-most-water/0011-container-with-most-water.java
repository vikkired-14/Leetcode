class Solution {
    public int maxArea(int[] height) {
      int left=0;
      int right = height.length-1;
      int maxHeight = Math.max(height[left],height[right]);
      int maxArea =0;
      while(left<=right){
        maxArea = Math.max(maxArea,(right-left)*(Math.min(height[left],height[right])));
        // System.out.println("left:"+ left + "right:"+ right);
        maxHeight = Math.max(height[left],height[right]);
         if(height[left]<maxHeight){
            left++;
        }else{
             right--;
        }
      } 
      return maxArea; 
    }
}