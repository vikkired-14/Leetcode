use std::collections::HashMap;

impl Solution {
    pub fn two_sum(nums: Vec<i32>, target: i32) -> Vec<i32> {
        let mut seen: HashMap<i32,i32> = HashMap::new();

        for(i,&num) in nums.iter().enumerate() {
            let comp = target - num;
            if let Some(&id) = seen.get(&comp){
                return vec![id,i as i32];
            }
            seen.insert(num,i as i32);
        }
        vec![-1,-1]
    }
}