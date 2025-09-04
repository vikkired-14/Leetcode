class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left=1, right =0;
        for(int pile:piles){
            right = Math.max(right,pile);
        }
        while(left<right){
            int mid = left +(right-left)/2;
            if(canEat(piles,h,mid)){
                right = mid;
            }else{
                left = mid+1;
            }
        }
        return left;
    }
    public boolean canEat(int[] piles,int h,int k){
        
        int hour=0 ;
        for(int pile:piles){
          hour += (pile +k-1)/k ;// ceiling division
          if(hour>h) return false;
        }
        return hour<= h;
    }
}