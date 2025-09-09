class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        
        int left =1;
        int right = arr.length-2;
        while(left<=right){
            int mid = left +(right-left)/2;
            if(mid>0 && mid<arr.length && arr[mid]>arr[mid-1] && arr[mid]>arr[mid+1])
              return mid;
            if(arr[mid]<arr[mid+1])
              left = mid+1;
            else
              right = mid-1;    
        }
        return -1;
    }
}