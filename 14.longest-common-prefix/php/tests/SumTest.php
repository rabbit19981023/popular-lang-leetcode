<?php

require 'vendor/autoload.php';        # <----- add this line

use PHPUnit\Framework\TestCase;       # <----- add this line
use Andrew\Leetcode\Sum;      # <----- add this line

final class SumTest extends TestCase  # <----- add this line
{
    public function testCase_01(): void # method name with `test*()`
    {
        $input_1 = 1;
        $input_2 = 4;
        $expected = 5;

        $result = Sum::do($input_1, $input_2);

        $this->assertEquals($expected, $result);
    }
}