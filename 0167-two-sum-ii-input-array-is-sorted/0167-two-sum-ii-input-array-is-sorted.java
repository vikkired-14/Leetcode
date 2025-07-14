class Solution {
    public int[] twoSum(int[] numbers, int target) {
        
        Map<Integer,Integer> cache = new HashMap<>();
        for(int i=0;i<numbers.length;i++){
            if(cache.containsKey(target-numbers[i])){
                return new int[]{cache.get(target-numbers[i])+1,i+1};
            }
            cache.put(numbers[i],i);
        }
        return new int[]{-1,-1};
    }
}