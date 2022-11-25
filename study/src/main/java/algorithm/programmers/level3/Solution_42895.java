package algorithm.programmers.level3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * N으로 표현
 * https://school.programmers.co.kr/learn/courses/30/lessons/42895
 */
public class Solution_42895 {
    public int solution(int N, int number) {
        List<Set<Integer>> list = new ArrayList<>();
        int answer = -1;
        for (int i = 0; i < 9; i++) {
            list.add(new HashSet<>());
        }

        list.get(1).add(N);

        for (int i = 2; i < 9; i++) {
            Set<Integer> set = list.get(i);

            for (int j = 1; j <= i; j++) {
                Set<Integer> preSet = list.get(j);
                Set<Integer> postSet = list.get(i - j);

                for (int preNum : preSet) {
                    for (int postNum : postSet) {
                        set.add(preNum + postNum);
                        set.add(preNum - postNum);
                        set.add(preNum * postNum);

                        if (preNum == 0 || postNum == 0) {
                            continue;
                        }
                        set.add(preNum / postNum);
                    }
                }
            }
            set.add(Integer.parseInt(String.valueOf(N).repeat(i)));
        }
        for (Set<Integer> set : list) {
            if (set.contains(number)) {
                answer = list.indexOf(set);
                break;
            }
        }

        return answer;
    }
}
