class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] edges = new int[numCourses];
        List<Integer>[] courses = new List[numCourses];
        for (int i = 0; i < numCourses; i++) {
            courses[i] = new ArrayList<Integer>();
        }
        for (int[] pair : prerequisites) {
            edges[pair[0]]++;
            courses[pair[1]].add(pair[0]);
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < edges.length; i++) {
            if (edges[i] == 0) {
                q.offer(i);
            }
        }
        int edgeCount = prerequisites.length;
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int course : courses[cur]) {
                edgeCount--;
                if (--edges[course] == 0) {
                    q.offer(course);
                }
            }
        }
        return edgeCount == 0;
    }
}