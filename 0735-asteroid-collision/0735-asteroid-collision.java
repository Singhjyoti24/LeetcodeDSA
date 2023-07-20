class Solution {
    public int[] asteroidCollision(int[] arr) {
        Stack<Integer> st = new Stack<>();
        
        for(int i=0;i<arr.length;i++){
            boolean flag = true;
            
            while (!st.isEmpty() && (st.peek() > 0 && arr[i] < 0)) {
                if (Math.abs(st.peek()) < Math.abs(arr[i])) {
                    st.pop();
                    continue;
                }
                else if (Math.abs(st.peek()) == Math.abs(arr[i])) {
                    st.pop();
                }

                flag = false;
                break;
            }

            if (flag) {
                st.push(arr[i]);
            }
        }
        
        int a = st.size();
        int[] ans = new int[a];
        
        for(int i=a-1;i>=0;i--){
            ans[i] = st.pop();
        }
        return ans;
    }
}