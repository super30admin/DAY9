/**
 * @param {number[]} nums
 * @return {number}
 */
var deleteAndEarn = function (nums) {
  let max = 0;
  for (let index = 0; index < nums.length; index++) {
    max = Math.max(max, nums[index]);
  }

  let earningsArray = new Array(max + 1);
  earningsArray.fill(0);
  for (let index = 0; index < nums.length; index++) {
    earningsArray[nums[index]] += earningsArray[nums[index]] + nums[index];
  }

  let second = earningsArray[0]; // Index - 2
  let first = Math.max(earningsArray[0], earningsArray[1]); // Index - 1

  for (let index = 2; index < earningsArray.length; index++) {
    let current = Math.max(earningsArray[index] + second, first);
    second = first;
    first = current;
  }

  return first;
};

test("Scenario #2: Happy Path", () => {
  let nums = [3, 4, 2];
  expect(deleteAndEarn(nums)).toStrictEqual(6);
});
