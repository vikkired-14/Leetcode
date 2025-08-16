class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int min =Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int n: nums){
            min = Math.min(min,n);
            max = Math.max(max,n);
        }
        int[] freq = new int[max-min+1];
        for(int n: nums){
            freq[n-min]++;
        }
        List<Integer>[] bucket = new List[nums.length+1];
        for(int i=0;i<freq.length;i++){
            if(freq[i]>0){
                if(bucket[freq[i]]==null)
                 bucket[freq[i]]=new ArrayList<>(); 
                 bucket[freq[i]].add(i+min);
            }
        }
        int[] res = new int[k];
        int idx=0;
      for(int i = bucket.length-1;i>=0 && idx<k;i--){
        if(bucket[i]!=null){
          for(int j : bucket[i]){
            res[idx++] =j;
             if (idx == k) break;
          }
        }
          
      } 

      return res; 
    }
}