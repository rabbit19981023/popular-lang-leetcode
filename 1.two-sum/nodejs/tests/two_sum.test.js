const { TwoSum } = require('../src/two_sum')
const twoSum = new TwoSum()

const processTestCase = (inputs, expected) => {
  const actual = twoSum._do(inputs.nums, inputs.target)
  expect(actual).toStrictEqual(expected)
}

describe('../src/two_sum.js', () => {
  it('test case 01', () => {
    const inputs = {
      nums: [3, 2, 4],
      target: 6
    }
    const expected = [1, 2]
    
    processTestCase(inputs, expected)
  })

  it('test case 02', () => {
    const inputs = {
      nums: [3, 3],
      target: 6
    }
    const expected = [0, 1]

    processTestCase(inputs, expected)
  })

  it('test case 03', () => {
    const inputs = {
      nums: [2, 7, 11, 15],
      target: 9
    }
    const expected = [0, 1]

    processTestCase(inputs, expected)
  })
})
