class Solution {
    private long maxStrength;
    public long maxStrength(int[] nums) {
        maxStrength = Integer.MIN_VALUE;
        helper(nums, 0, 1, 0);
        return maxStrength;
    }

    private void helper(int[] nums, int index, long product, int size) {
        if (index >= nums.length) {
            if(size != 0) maxStrength = Math.max(maxStrength, product);
            return;
        }

        helper(nums, index + 1, product * nums[index], size + 1);
        helper(nums, index + 1, product, size);
    }
}