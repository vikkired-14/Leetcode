use std::collections::HashMap;

impl Solution {
    pub fn subarray_sum(nums: Vec<i32>, k: i32) -> i32 {
        let mut freq: HashMap<i64, i32> = HashMap::new(); 
        freq.insert(0,1);
        let mut sum: i64 = 0;
        let mut count: i32=0;
        for n in nums {
            sum += n as i64;
            let need = sum - k as i64;
            if let Some(&c) = freq.get(&need){
                count += c;
            }
            *freq.entry(sum).or_insert(0) += 1;
        }
        count
    }
}