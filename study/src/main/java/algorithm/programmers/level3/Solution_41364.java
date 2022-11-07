package algorithm.programmers.level3;

import java.util.*;

/**
 * 여행경로
 * https://school.programmers.co.kr/learn/courses/30/lessons/43164
 */
public class Solution_41364 {
    List<String> answerList = new ArrayList<>();
    public String[] solution(String[][] tickets) {
        boolean[] visit= new boolean[tickets.length];
        dfs("ICN", "ICN", tickets, visit, 0);
        Collections.sort(answerList);
        return answerList.get(0).split(" ");
    }

    private void dfs(String to, String path, String[][] tickets, boolean[] visit, int depth) {
        if (depth == tickets.length) {
            answerList.add(path);
            return;
        }

        for (int i = 0; i < tickets.length; i++) {
            if (to.equals(tickets[i][0]) && !visit[i]) {
                visit[i] = true;
                dfs(tickets[i][1], path + " " + tickets[i][1], tickets, visit, depth + 1);
                visit[i] = false;
            }
        }
    }


    public static void main(String[] args) {
        Solution_41364 sol = new Solution_41364();
        sol.solution(new String[][] {{"ICN","SFO"},{"ICN","ATL"},{"SFO","ATL"},{"ATL","ICN"},{"ATL","SFO"}});
    }
}
