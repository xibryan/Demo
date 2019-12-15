package sample.algorithm.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/course-schedule-ii/
 * 210. 课程表 II
 */
public class FindOrder {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Set<Integer> roots = new HashSet<>(numCourses);
        for (int i = 0; i < numCourses; i++) {
            roots.add(i);
        }

        Map<Integer, Set<Integer>> preReqMap = new HashMap<>();
        for (int i = 0; i < prerequisites.length; i++) {
            Set<Integer> preReqSet = preReqMap.get(prerequisites[i][0]);
            if (Objects.isNull(preReqSet)) {
                preReqSet = new HashSet<>();
                preReqMap.put(prerequisites[i][0], preReqSet);
            }

            preReqSet.add(prerequisites[i][1]);
            roots.remove(prerequisites[i][1]);
        }

        Set<Integer> parent = new HashSet<>();
        Set<Integer> visited = new HashSet<>();
        List<Integer> resultList = new LinkedList<>();
        for (Integer root : roots) {
            try {
                dfs(preReqMap, root, visited, resultList, parent);
            } catch (Exception e) {
                return new int[0];
            }
        }

        if (resultList.size() < numCourses) {
            return new int[0];
        }

        int index = 0;
        int[] result = new int[numCourses];
        for (Integer integer : resultList) {
            result[index++] = integer;
        }

        return result;
    }

    private void dfs(Map<Integer, Set<Integer>> preReqMap, int root, Set<Integer> visited, List<Integer> result,
        Set<Integer> parent) throws Exception {
        if (visited.contains(root)) {
            if (parent.contains(root)) {
                throw new Exception();
            }

            return;
        }

        visited.add(root);
        parent.add(root);
        Set<Integer> preReqSet = preReqMap.get(root);
        if (preReqSet != null) {
            for (Integer preReq : preReqSet) {
                dfs(preReqMap, preReq, visited, result, parent);
            }
        }

        parent.remove(root);
        result.add(root);
    }
}
