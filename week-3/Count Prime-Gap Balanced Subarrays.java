
class Solution {

    public boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public int primeSubarray(int[] nums, int k) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        Deque<Integer> q = new ArrayDeque<>();
        int l = 0, r = 0;
        int ans = 0;
        while (r < nums.length) {
            if (isPrime(nums[r])) {
                map.put(nums[r], map.getOrDefault(nums[r], 0) + 1);
                q.add(r);
            }
            while (map.size() >= 2 && map.lastKey() - map.firstKey() > k) {
                if (isPrime(nums[l])) {
                    int freq = map.get(nums[l]);
                    if (freq == 1) {
                        map.remove(nums[l]); 
                    }else {
                        map.put(nums[l], freq - 1);
                    }
                    q.pollFirst();
                }
                l++;
            }
            if (q.size() >= 2) {
                int firstPos = q.pollLast();
                int secPos = q.peekLast();
                ans += secPos - l + 1;
                q.add(firstPos);
            }
            r++;
        }
        return ans;
    }
}
