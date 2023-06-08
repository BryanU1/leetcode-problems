class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> currComb = new ArrayList<>();
        combination(candidates, target, 0, 0, currComb, ans);
        return ans;
    }

    public void combination(int[] candidates, int target, int index, int sum, List<Integer> currComb, List<List<Integer>> ans) {
        if (sum > target) return;
        if (sum == target) {
            ans.add(new ArrayList<Integer>(currComb));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            sum += candidates[i];
            currComb.add(candidates[i]);
            combination(candidates, target, i, sum, currComb, ans);
            sum -= candidates[i];
            currComb.remove(currComb.size() - 1);
        }
    }
}