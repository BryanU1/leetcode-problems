class Solution {
    public List<List<Integer>> permute(int[] nums) {
        Set<Integer> set = new HashSet<>();
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        backtrack(nums, new ArrayList<Integer>(), set, ans);
        return ans;
    }
    public void backtrack(int[] nums, List<Integer> currPerm, Set<Integer> set, List<List<Integer>> ans) {
        if (currPerm.size() == nums.length) {
            ans.add(new ArrayList<>(currPerm));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) continue;
            set.add(nums[i]);
            currPerm.add(nums[i]);
            backtrack(nums, currPerm, set, ans);
            set.remove(nums[i]);
            currPerm.remove(currPerm.size() - 1);
        }
    }
}