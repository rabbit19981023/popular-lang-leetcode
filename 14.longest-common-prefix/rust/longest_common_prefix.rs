struct Solution { }

impl Solution {
    pub fn new() -> Solution {
        return Solution { };
    }

    pub fn longest_common_prefix(&self, strs: Vec<String>) -> String {
        if ! self.is_valid(&strs) {
            return "".to_owned();
        }

        let mut low: usize = 1;
        let mut high: usize = self.get_min_len(&strs);
        let mut mid: usize;

        while low <= high {
            mid = (low + high) / 2;

            if self.is_common_prefix(mid, &strs) {
                low = mid + 1;
                continue
            }

            high = mid - 1;
        }

        mid = (low + high) / 2;
        return strs[0][0..mid].to_owned();
    }

    fn is_valid(&self, strs: &Vec<String>) -> bool {
        return ! (strs.len() == 0);
    }

    fn get_min_len(&self, strs: &Vec<String>) -> usize {
        let mut min_len: usize = strs[0].len();
        
        for str in strs.iter() {
            if str.len() < min_len {
                min_len = str.len();
            }
        }

        return min_len;
    }

    fn is_common_prefix(&self, mid: usize, strs: &Vec<String>) -> bool {
        let prefix = &strs[0][0..mid];

        for str in strs.iter() {
            if ! str.starts_with(prefix) {
                return false;
            }
        }

        return true;
    }
}

struct Test {
    pub strs: Vec<String>
}

fn main() {
    let test_01 = Test {
        strs: vec![ "flower", "flow", "flight" ]
            .into_iter()
            .map(String::from)
            .collect()
    };
    let test_02 = Test {
        strs: vec![ "dog", "racecar", "car" ]
            .into_iter()
            .map(String::from)
            .collect()
    };

    let solution = Solution::new();

    let result_01 = solution.longest_common_prefix(test_01.strs);
    let result_02 = solution.longest_common_prefix(test_02.strs);

    println!();
    println!("Expected: 'fl'\nOutput: {}", result_01);
    println!();

    println!("Expected: ''\nOutput: {}", result_02);
    println!();
}
