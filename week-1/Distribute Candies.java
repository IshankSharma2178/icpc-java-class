
class Solution {

    public int distributeCandies(int[] nums) {
        int n = nums.length;
        HashSet<Integer> set = new HashSet<>();

        for (int it : nums) {
            set.add(it);
        }

        if (n / 2 < set.size()) {
            return n / 2;
        }
        return set.size();
    }
}
