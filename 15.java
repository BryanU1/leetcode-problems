class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> triplets = new HashSet<>();
        if (nums.length == 0) return Collections.emptyList();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) triplets.add(Arrays.asList(nums[i], nums[j++], nums[k--]));
                if (sum > 0) k--;
                if (sum < 0) j++;
            }
        }
        return new ArrayList<>(triplets);
    }
}