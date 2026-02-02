
class Solution {

    public int timeRequiredToBuy(int[] tickets, int k) {
        int cnt = 0;
        Queue<Integer> q = new LinkedList<>();
        int n = tickets.length;
        for (int i = 0; i < n; i++) {
            q.add(i);
        }
        while (!q.isEmpty()) {
            int x = q.poll();
            tickets[x]--;
            cnt++;
            if (x == k && tickets[x] == 0) {
                return cnt;
            }
            if (tickets[x] != 0) {
                q.add(x);
            }
        }
        return cnt;
    }
}
