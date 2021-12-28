use leetcode::Solution;

#[test]
fn have_longest_common_prefix() {
	let input: Vec<String> = vec![ "flower", "flow", "flight" ]
							.into_iter()
							.map(String::from)
							.collect();
	let expected: &str = "fl";

	process_test_case(&input, expected);
}

#[test]
fn no_longest_common_prefix() {
	let input: Vec<String> = vec![ "dog", "racecar", "car" ]
							.into_iter()
							.map(String::from)
							.collect();
	let expected: &str = "";

	process_test_case(&input, expected);
}

fn process_test_case(input: &Vec<String>, expected: &str) {
	let solution: Solution = Solution::new();
	let actual: String = solution.longest_common_prefix(input);
	assert_eq!(&actual, expected);
}
