class Solution {
    public boolean validMountainArray(int[] arr) {
        int n= arr.length;
        if(arr.length<3)
          return false;
          int i=0;
        while(i+1< arr.length && arr[i]<arr[i+1]){
            i++;
        }  

        if(i==0 || i== n-1 )
          return false;
        while(i+1<n && arr[i]>arr[i+1])
          i++;
        return i== n-1;    
    }
}