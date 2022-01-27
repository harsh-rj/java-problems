/* 
    Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
    You may assume that each input would have exactly one solution, and you may not use the same element twice.
    You can return the answer in any order.

    e.g.:
    Input: nums = [2,7,11,15], target = 9
    Output: [0,1]
    Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
*/

public class theSum {
    public static void main(String[] args) {
        int[] nums = { 5, 87, 3, 100, 17, 13 };
        int target = 100;
        int[] ans = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int sum = nums[i] + nums[j];
                if (sum == target) {
                    ans[0] = i;
                    ans[1] = j;
                }
            }
        }
        System.out.printf("[%d, %d]", ans[0], ans[1]);
    }
}

/*
    Output:
    [1, 5]
 */