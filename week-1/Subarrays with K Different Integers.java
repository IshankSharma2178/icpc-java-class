
lass Solution {
    public static int anirudh(int nums[], int k){
           HashMap<Integer, Integer> map = new HashMap<>();
        int start = 0, end = 0;
        int cnt = 0;
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        while(end < n){
            map.put(nums[end], map.getOrDefault(nums[end],0) + 1);
            
            while(start <= end && map.size() > k){
                if(map.get(nums[start]) == 1){
                    map.remove(nums[start]);
                } else {
                    map.put(nums[start], map.get(nums[start])- 1);
                }
                start++;
            }
            
            cnt += end  - start + 1;
            end++;
        }
        return cnt;
    }
    public int subarraysWithKDistinct(int[] nums, int k) {
      return anirudh(nums, k) - anirudh(nums, k- 1);
    }
}
