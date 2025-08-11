use std::collections::HashMap;

impl Solution {
    pub fn longest_consecutive(nums: Vec<i32>) -> i32 {
        let mut seen: HashMap<i32, i32> = HashMap::new();
        let mut max_len = 0;

        for &n in nums.iter() {
            if !seen.contains_key(&n) {
                let left = *seen.get(&(n-1)).unwrap_or(&0);
                let right = *seen.get(&(n + 1)).unwrap_or(&0);
                let len = left + right + 1;

                seen.insert(n - left, len);
                seen.insert(n + right, len);
                seen.insert(n, len);

                max_len = max_len.max(len);
            }
        }

        max_len
    }
}
