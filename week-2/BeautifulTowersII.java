class Solution {
    public long maximumSumOfHeights(List<Integer> arr) {
        if(arr.size() == 1) return arr.get(0);
        Stack<Integer> st = new Stack<>();
        int[] minRight = new int[arr.size()];
        int[] minLeft = new int[arr.size()];
        for(int i=0;i<arr.size();i++){
            while(!st.isEmpty() && arr.get(st.peek()) >= arr.get(i)) st.pop();
            if(!st.isEmpty()) minLeft[i] = st.peek();
            else minLeft[i] = -1;
            st.push(i);
        }       
        st.clear();
        for(int i=arr.size()-1;i>=0;i--){
            while(!st.isEmpty() && arr.get(st.peek()) >= arr.get(i)) st.pop();
            if(!st.isEmpty()) minRight[i] = st.peek();
            else minRight[i] = arr.size();
            st.push(i);
        }
        long[] left = new long[arr.size()];
        long[] right = new long[arr.size()];
        for(int i=arr.size()-1;i>=0;i--){
            right[i] = ((long)minRight[i] - (long)i) * (long)arr.get(i) +  (minRight[i] >= arr.size() ? 0 : (long) right[(minRight[i])]);
        }
        for(int i=0;i<arr.size();i++){
            left[i] = ((long) i - (long) minLeft[i]) * (long) arr.get(i) + (minLeft[i] < 0 ? 0 : (long) left[minLeft[i]]);
        }
        long ans = 0;
        for(int i=0;i<arr.size()-1;i++){
            ans = Math.max(ans,right[i+1] + left[i]);
        }
        return ans;
    }
}