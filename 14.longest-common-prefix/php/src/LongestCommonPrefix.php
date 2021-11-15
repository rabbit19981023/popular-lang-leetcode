<?php

namespace Andrew\Leetcode;

final class LongestCommonPrefix
{
	final static function do(array $strs): string
	{
		if (! self::isValid($strs)) {
			return '';
		}

		$low = 0;
		$high = self::getMinLen($strs);

		while ($low <= $high) {
			$mid = intval(($low + $high) / 2);

			if (self::isCommonPrefix($mid, $strs)) {
				$low = $mid + 1;
				continue;
			}

			$high = $mid - 1;
		}

		$result = intval(($low + $high) / 2);
		return substr($strs[0], 0, $result);
	}

	final static function isValid(array $strs): bool
	{
		return (! ($strs == null | count($strs) == 0));
	}

	final static function getMinLen(array $strs): int
	{
		$minLen = strlen($strs[0]);
		
		for ($i = 1; $i < count($strs); $i++) {
			if (strlen($strs[$i]) < $minLen) {
				$minLen = strlen($strs[$i]);
			}
		}

		return $minLen;
	}

	final static function isCommonPrefix(int $mid, array $strs): bool
	{
		$prefix = substr($strs[0], 0, $mid);

		for ($i = 1; $i < count($strs); $i++) {
			if (! str_starts_with($strs[$i], $prefix)) {
				return false;
			}
		}

		return true;
	}
}
