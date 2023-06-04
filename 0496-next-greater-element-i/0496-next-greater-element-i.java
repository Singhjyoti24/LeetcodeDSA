class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> st = new Stack<>();

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = nums2.length - 1; i >= 0; i--) {
            if (st.isEmpty()) {
                map.put(nums2[i], -1);
            } else {
                while (!st.isEmpty() && nums2[st.peek()] < nums2[i]) {
                    st.pop();
                }

                if (st.isEmpty()) {
                    map.put(nums2[i], -1);
                } else {
                    map.put(nums2[i], nums2[st.peek()]);
                }
            }
            st.push(i);
        }

        int[] ans = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            ans[i] = map.get(nums1[i]);
        }
        return ans;
    }
}