package sample.algorithm.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
https://leetcode.cn/problems/course-schedule/
207. 课程表
你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。

在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，其中 prerequisites[i] = [ai, bi] ，表示如果要学习课程 ai 则 必须 先学习课程  bi 。

例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。
请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。
 */
public class CanFinish {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> preRequisiteMap = new HashMap<>();
        for (int[] prerequisite : prerequisites) {
            List<Integer> value = preRequisiteMap.computeIfAbsent(prerequisite[0], (t) -> new ArrayList<>());
            value.add(prerequisite[1]);
        }

        int[] courses = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i, preRequisiteMap, courses)) {
                return false;
            }
        }

        return true;
    }

    private boolean dfs(int i, Map<Integer, List<Integer>> preRequisiteMap, int[] courses) {
        if (courses[i] == 1) {
            return false;
        } else if (courses[i] == 2) {
            return true;
        }

        courses[i] = 1;
        List<Integer> integers = preRequisiteMap.get(i);
        if (integers != null) {
            for (Integer integer : integers) {
                boolean result = dfs(integer, preRequisiteMap, courses);
                if (!result) {
                    return false;
                }
            }
        }

        courses[i] = 2;
        return true;
    }
}
