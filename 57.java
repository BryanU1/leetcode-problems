class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> arr = new ArrayList<>();
        int ind = 0;
        while(ind < intervals.length) {
            if (intervals[ind][1] < newInterval[0]) {
                arr.add(intervals[ind]);
            } else if (intervals[ind][0] > newInterval[1]) {
                arr.add(newInterval);
                newInterval = intervals[ind];
            } else {
                newInterval[0] = Math.min(intervals[ind][0], newInterval[0]);
                newInterval[1] = Math.max(intervals[ind][1], newInterval[1]);
            }
            ind++;
        }
        arr.add(newInterval);
        return arr.toArray(new int[arr.size()][]);
    }
}