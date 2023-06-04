class Solution {
    public int trap(int[] height) {
        int[] ngl = nextGreaterElementLeft(height);
        int[] ngr = nextGreaterElementRight(height);

        int sum = 0, n = height.length;
        int[] min = new int[n];

        for (int i = 0; i < n; i++) {
            min[i] = Math.min(ngl[i], ngr[i]);
        }

        for (int i = 0; i < n; i++) {
            sum += min[i] - height[i];
        }
        return sum;
    }

    public int[] nextGreaterElementLeft(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];

        ans[0] = nums[0];
        for (int i = 1; i < n; i++) {
            if (ans[i - 1] > nums[i]) {
                ans[i] = ans[i - 1];
            } else {
                ans[i] = nums[i];
            }
        }
        return ans;
    }

    public int[] nextGreaterElementRight(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];

        ans[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            if (ans[i + 1] > nums[i]) {
                ans[i] = ans[i + 1];
            } else {
                ans[i] = nums[i];
            }
        }
        return ans;
    }
}