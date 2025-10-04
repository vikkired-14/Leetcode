class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int n: nums){
            min = Math.min(n,min);
            max = Math.max(n,max);
        }
        int[] count = new int[max-min+1];
        for(int n : nums){
            count[n-min]++;
        }
        List<Integer>[] bucket = new List[nums.length+1];
        for(int i=0;i<count.length;i++){
            if(count[i]>0){
            if(bucket[count[i]]==null)
                bucket[count[i]] = new ArrayList<>();
             bucket[count[i]].add(i+min); 
            }
        }
        int idx=0;
        int[] res = new int[k];
        for(int i = bucket.length-1;i>=0;i--){
            if(bucket[i]!=null){
                for(int j: bucket[i]){
                  if(idx<res.length)  
                   res[idx++] = j;
                  if(idx==k) break;
                }
            }
        }
     return res;
    }
}