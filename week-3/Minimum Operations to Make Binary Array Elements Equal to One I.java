
class Solution {

    public int minOperations(int[] nums) {
        int ans = 0;

        for (int i = 0; i <= nums.length - 3; i++) {
            if (nums[i] == 0) {
                nums[i] = 1 - nums[i];
                nums[i + 1] = 1 - nums[i + 1];
                nums[i + 2] = 1 - nums[i + 2];
                ans++;
            }
        }
        for (int it : nums) {
            if (it == 0) {
                return -1;
            }
        }
        return ans;
    }
}
