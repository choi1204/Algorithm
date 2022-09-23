package algorithm.programmers.level3;

import java.util.*;

/**
 * 여행경로
 * https://school.programmers.co.kr/learn/courses/30/lessons/43164
 */

public class Solution_43164 {
    public String[] solution(String[][] tickets) {
        List<String> answer = new ArrayList<>();
        int index = 0;
        Map<String, Integer> map = new HashMap<>();
        List<String>[] list = new ArrayList[10000];

        for (int i = 0; i < 10000; i++) {
            list[i] = new ArrayList<>();
        }
        for (String[] ticket : tickets) {
            for (String airport : ticket) {
                if (!map.containsKey(airport)) {
                    map.put(airport, index++);
                }
            }
            int target = map.get(ticket[0]);
            list[target].add(ticket[1]);
        }
        for (List<String> strList : list) {
            strList.sort((Comparator.naturalOrder()));
        }

        String airport = "ICN";
        while(true) {
            answer.add(airport);
            int now = map.get(airport);
            if (list[now].isEmpty()) {
                break;
            }
            airport = list[now].get(0);
            list[now].remove(0);
        }

        return answer.toArray(new String[0]);
    }

    public static void main(String[] args) {
        Solution_43164 s = new Solution_43164();
        s.solution(new String[][]{{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}});
    }
}
