class Solution {
    public int majorityElement(int[] nums) {
        int threshold = nums.length / 2;
        Map<Integer, Integer> data = new HashMap<>();
        for (int n : nums) {
            if (data.containsKey(n)) {
                data.put(n, data.get(n) + 1);
            } else {
                data.put(n, 1);
            }
            if (data.get(n) > threshold) {
                return n;
            }
        }
        return nums[0];
    }
}