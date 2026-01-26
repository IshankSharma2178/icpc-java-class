
class Solution {

    public long numberOfSubarrays(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        Map<Integer, Integer> prevOccr = new HashMap<>();
        int big[] = new int[nums.length];
        Arrays.fill(big, -1);
        LinkedList<Integer> mon = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            while (!mon.isEmpty() && nums[mon.peek()] <= nums[i]) {
                mon.pop();
            }
            if (!mon.isEmpty()) {
                big[i] = mon.peek();
            }
            mon.push(i);
        }

        long result = 0;
        for (int i = 0; i < nums.length; i++) {
            int prvOccr = prevOccr.getOrDefault(nums[i], -1);
            int curcnt = count.getOrDefault(nums[i], 0);
            if (prvOccr < big[i]) {
                count.put(nums[i], 1);
                result += 1;
            } else {
                count.put(nums[i], curcnt + 1);
                result += curcnt + 1;
            }
            prevOccr.put(nums[i], i);
        }
        return result;
    }
}
