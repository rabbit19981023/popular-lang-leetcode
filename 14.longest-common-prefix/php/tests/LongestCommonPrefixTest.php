<?php

require 'vendor/autoload.php';

use PHPUnit\Framework\TestCase;
use Andrew\Leetcode\LongestCommonPrefix;

final class LongestCommonPrefixTest extends TestCase
{
	private function processTestCase(array $input, string $expected): void
	{
		$actual = LongestCommonPrefix::do($input);
		$this->assertEquals($expected, $actual);
	}

	final function test_have_longest_common_prefix(): void
	{
		$input = [ 'flower', 'flow', 'flight' ];
		$expected = 'fl';

		$this->processTestCase($input, $expected);
	}

	final function test_no_longest_common_prefix(): void
	{
		$input = [ 'dog', 'racecar', 'car' ];
		$expected = '';

		$this->processTestCase($input, $expected);
	}
}
