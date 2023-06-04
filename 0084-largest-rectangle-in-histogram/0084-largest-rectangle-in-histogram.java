class Solution {
    public int largestRectangleArea(int[] heights) {
        int[] nsl = nextSmallerElement(heights);
        int[] nsr = nextSmallerElementRight(heights);

        int n = heights.length;
        int[] width = new int[n];
        for(int i=0;i<n;i++){
            width[i] = nsr[i]-nsl[i]-1;
        }

        int max = 0;
        for(int i=0;i<n;i++){
            max = Math.max(max, width[i]*heights[i]);
        }
        return max;
    }

    public int[] nextSmallerElement(int[] nums) {
        Stack<Integer> st = new Stack<>();
        int n = nums.length;
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            if (st.isEmpty()) {
                ans[i] = -1;
            } else {
                while (!st.isEmpty() && nums[st.peek()] >= nums[i]) {
                    st.pop();
                }

                if (st.isEmpty()) {
                    ans[i] = -1;
                } else {
                    ans[i] = st.peek();
                }
            }

            st.push(i);
        }
        return ans;
    }

    public int[] nextSmallerElementRight(int[] nums) {
        Stack<Integer> st = new Stack<>();
        int n = nums.length;
        int[] ans = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            if (st.isEmpty()) {
                ans[i] = n;
            } else {
                while (!st.isEmpty() && nums[st.peek()] >= nums[i]) {
                    st.pop();
                }

                if (st.isEmpty()) {
                    ans[i] = n;
                } else {
                    ans[i] = st.peek();
                }
            }

            st.push(i);
        }
        return ans;
    }
    
    
}