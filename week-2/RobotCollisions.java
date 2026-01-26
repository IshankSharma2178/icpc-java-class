
class Solution {

    public List<Integer> survivedRobotsHealths(int[] post, int[] health, String dir) {
        Stack<int[]> st = new Stack<>();
        int[][] arr = new int[health.length][4];
        for (int i = 0; i < post.length; i++) {
            arr[i][0] = health[i];
            arr[i][1] = post[i];
            arr[i][2] = dir.charAt(i) == 'L' ? 0 : 1;
            arr[i][3] = i;
        }
        Arrays.sort(arr, (a, b) -> a[1] - b[1]);
        for (int i = 0; i < post.length; i++) {
            boolean flag = true;
            while (arr[i][2] == 0 && st.size() != 0) {
                if (st.peek()[0] == arr[i][0]) {
                    flag = false;
                    arr[i][0] = 0;
                    arr[st.pop()[1]][0] = 0;
                    break;
                } else if (st.peek()[0] > arr[i][0]) {
                    if (st.peek()[0] == 1) {
                        arr[st.pop()[1]][0] = 0;
                        arr[i][0] = 0;
                        flag = false;
                    } else {
                        st.peek()[0]--;
                        arr[st.peek()[1]][0]--;
                        arr[i][0] = 0;
                        flag = false;
                    }
                    break;
                } else {
                    arr[st.pop()[1]][0] = 0;
                    arr[i][0]--;
                }
            }
            if (!flag) {
                continue;
            }
            if (st.size() != 0 || (st.size() == 0 && arr[i][2] != 0)) {
                st.push(new int[]{arr[i][0], i});
            }
        }
        for (int i = 0; i < post.length; i++) {
            int idx = arr[i][3];
            int val = arr[i][0];
            health[idx] = val;
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < post.length; i++) {
            if (health[i] != 0) {
                ans.add(health[i]);
            }
        }
        return ans;
    }
}
