package sample.algorithm.leetcode;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/queue-reconstruction-by-height/
 * 406. 根据身高重建队列
 */
public class ReconstructQueue {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (o1, o2) -> {
            if (o1[0] != o2[0]) {
                return Integer.compare(o2[0], o1[0]);
            }

            return Integer.compare(o1[1], o2[1]);
        });

        for (int i = 0; i < people.length; i++) {
            int index = people[i][1];
            if (index < i) {
                int[] current = people[i];
                for (int j = i; j > index; j--) {
                    people[j] = people[j - 1];
                }
                people[index] = current;
            }
        }

        return people;
    }
}
