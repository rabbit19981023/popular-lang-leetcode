use leetcode::Solution;

fn process_test_case(input: &Vec<String>, expected: &str) {
	let solution: Solution = Solution::new();
	let result: String = solution.longest_common_prefix(input);
	assert_eq!(&result, expected);
}

#[test]
fn test_case_01() {
	let input: Vec<String> = vec![ "flower", "flow", "flight" ]
							.into_iter()
							.map(String::from)
							.collect();
	let expected: &str = "fl";

	process_test_case(&input, expected);
}

#[test]
fn test_case_02() {
	let input: Vec<String> = vec![ "dog", "racecar", "car" ]
							.into_iter()
							.map(String::from)
							.collect();
	let expected: &str = "";

	process_test_case(&input, expected);
}
