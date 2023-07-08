class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> st = new Stack<>();
        
        for(int i=0;i<num.length();i++){
            char ch = num.charAt(i);
            while(st.size()>0 && k>0 && st.peek()>ch){
                st.pop();
                k--;
            }
            st.push(ch);
        }
        
        while(k>0){
            st.pop();
            k--;
        }
        
        char[] arr = new char[st.size()];
        int l=arr.length-1;
        while(l>=0){
            arr[l--]=st.pop();
        }
        
        int d=0;
        while(d<arr.length && arr[d]=='0')d++;
        
        StringBuilder sb = new StringBuilder();
        while(d<arr.length){
            sb.append(arr[d++]);
        }
        if(sb.length()==0){
           sb.append('0');
        }
        
        return sb.toString();
    }
}


