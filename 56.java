class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> ans = new ArrayList<>();
        Arrays.sort(intervals, (pair1, pair2) -> Integer.compare(pair1[0], pair2[0]));
        int[] newInterval = intervals[0];
        ans.add(newInterval);
        for (int[] interval : intervals) {
            if (newInterval[1] >= interval[0]) {
                newInterval[1] = Math.max(interval[1], newInterval[1]);
            } else {
                newInterval = interval;
                ans.add(newInterval);
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }
}