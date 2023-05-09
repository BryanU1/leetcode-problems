class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> data = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (data.containsKey(complement)) {
                return new int[] {data.get(complement), i};
            }
            data.put(nums[i], i);
        }
        return new int[] {-1, -1};
    }
}