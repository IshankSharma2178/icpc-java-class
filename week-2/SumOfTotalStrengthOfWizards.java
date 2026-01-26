class Solution {
    int mod = 1000000000+7;
    public int totalStrength(int[] arr) {
        long[] pre1 = new long[arr.length+2];
        long[] pre2 = new long[arr.length+2];
        for(int i = 0; i < arr.length; i++){
            pre1[i + 1] = (pre1[i] + arr[i] ) % mod;
            pre2[i + 1] = (pre2[i] + pre1[i + 1]) % mod;
        }
        Stack<Integer> st = new Stack<>();
        int[] next = new int[arr.length];
        int[] prev = new int[arr.length];
        for(int i=arr.length-1;i>=0;i--){
            while(st.size()!=0 && arr[st.peek()] >= arr[i]) st.pop();
            next[i] = st.size() == 0 ? arr.length : st.peek();
            st.push(i);
        }
        st.clear();
        for(int i=0;i<arr.length;i++){
            while(st.size()!=0 && arr[st.peek()] > arr[i]) st.pop();
            prev[i] = st.size() == 0 ? -1 : st.peek();
            st.push(i);
        }
        long ans = 0;
        for(int i=0;i<arr.length;i++){
            int leftCount = i - prev[i];
            int rightCount = next[i] - i; 
            long leftSum = (pre2[i] - (prev[i] < 0 ? 0 : pre2[prev[i]])) * rightCount % mod;
            long rightSum = (pre2[next[i]] - pre2[i] + mod) % mod * leftCount % mod;
            long total = (rightSum - leftSum + mod) % mod;
            ans = (ans + arr[i] * total) % mod;
        }
        return (int) ans;
    }
}