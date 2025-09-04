class Solution {
    public int shipWithinDays(int[] weights, int days) {
        
        int left = 0;
        int right =0;
        for(int wt: weights){
            left = Math.max(wt,left);
            right += wt;
        }
        // System.out.println(left +":" + right);
        while(left<right){
            int mid = left+(right-left)/2;
            if(canShip(weights,days,mid)){
                right = mid;
            }else{
                left = mid+1;
            }
        }
        return left;
    }

    public boolean canShip(int[] weights,int days,int capacity){
        int count =1;
        int currLoad=0;
        for(int wt: weights){
           if(currLoad+wt>capacity){
             count++;
             currLoad =0;
           }
           currLoad += wt;
           if(count>days) return false;

        }
        return true;
    }
}