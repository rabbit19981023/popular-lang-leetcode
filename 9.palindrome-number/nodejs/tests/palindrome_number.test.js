const { PalindromeNumber } = require('../src/palindrome_number')

describe('../src/palindrome_number.js', () => {
  it('positive number', () => {
    const inputs = {
      num: 121
    }
    const expected = true

    processTestCase(inputs, expected)
  })

  it('negative number', () => {
    const inputs = {
      num: -121
    }
    const expected = false

    processTestCase(inputs, expected)
  })

  it('zero ending number', () => {
    const inputs = {
      num: 10
    }
    const expected = false

    processTestCase(inputs, expected)
  })
})

const palindromeNumber = new PalindromeNumber()

const processTestCase = (inputs, expected) => {
  const actual = palindromeNumber.do(inputs.num)
  expect(actual).toBe(expected)
}
