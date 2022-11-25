package algorithm.programmers._2022_kakao_intership;

import java.util.*;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/118668
 * 코딩테스트 공부
 */
public class Solution_118668 {
    public int solution(int alp, int cop, int[][] problems) {
        int answer = 0;
        int max_alp = 0;
        int max_cop = 0;

        List<int[]> list = new ArrayList<>();
        list.add(new int[] {0, 0, 1, 0, 1});
        list.add(new int[] {0, 0, 0, 1, 1});
        for (int[] problem : problems) {
            max_alp = Math.max(problem[0], max_alp);
            max_cop = Math.max(problem[1], max_cop);
            list.add(problem);
        }

        boolean[][] visit = new boolean[max_alp + 1][max_cop + 1];
        Queue<int[]> pq = new PriorityQueue<>(Comparator.comparing(a -> a[2]));
        pq.add(new int[] {alp, cop, 0});

        while(!pq.isEmpty()) {
            int[] now = pq.poll();
            if (visit[now[0]][now[1]]) {
                continue;
            }
            if (now[0] >= max_alp && now[1] >= max_cop) {
                answer = now[2];
                break;
            }
            visit[now[0]][now[1]] = true;
            for (int[] problem : list) {
                if (check(now, problem, visit)) {
                    pq.add(solve(now,problem));
                }
            }
        }

        return answer;
    }

    private int[] solve(int[] now, int[] problem) {
        return new int[] {now[0] + problem[2], now[1] + problem[3], now[2] + problem[4]};
    }

    private boolean check(int[] now, int[] problem, boolean[][] visit) {
        int solveAlp = now[0] + problem[2];
        int solveCop = now[1] + problem[3];
        return now[0] >= problem[0] && now[1] >= problem[1] && !visit[solveAlp][solveCop];
    }

    public static void main(String[] args) {
        Solution_118668 sol = new Solution_118668();
        sol.solution(10, 10, new int[][] {{10,15,2,1,2},{20,20,3,3,4}});
    }
}
