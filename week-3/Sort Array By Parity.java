
class Solution {

    public int[] deckRevealedIncreasing(int[] deck) {
        int n = deck.length;
        Queue<Integer> q = new LinkedList<>();
        Arrays.sort(deck);
        int idx = 0;
        int ans[] = new int[n];
        for (int i = 0; i < n; i++) {
            q.offer(i);
        }

        while (!q.isEmpty()) {
            ans[q.poll()] = deck[idx++];
            if (!q.isEmpty()) {
                q.offer(q.poll());
            }
        }
        return ans;
    }
}
