import java.util.*;

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
    
        List<Integer>[] adj = new ArrayList[numCourses];
        int[] indegree = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] pre : prerequisites) {
            int course = pre[0];
            int prerequisite = pre[1];
            adj[prerequisite].add(course);
            indegree[course]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        int[] result = new int[numCourses];
        int index = 0;

       
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            result[index++] = curr;

            for (int neighbor : adj[curr]) {
                indegree[neighbor]--;
               
                if (indegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }

        if (index == numCourses) {
            return result;
        } else {
            return new int[0];
        }
    }
}
