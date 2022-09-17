package algorithm.programmers.level2;

import java.util.*;

/**
 * 메뉴 리뉴얼
 * https://school.programmers.co.kr/learn/courses/30/lessons/72411
 */
class Solution {
    public static String[] solution(String[] orders, int[] course) {
        List<String> answer = new ArrayList<>();

        for (int i = 0; i < orders.length; i++) {
            char[] orderChars = orders[i].toCharArray();
            Arrays.sort(orderChars);
            orders[i] = String.valueOf(orderChars);
        }

        for (int courseSize : course) {
            Map<String, Integer> map = new HashMap<>();
            for (String order : orders) {
                combination("", order, courseSize, map);
            }
            if (!map.isEmpty()) {
                List<Integer> countList = new ArrayList<>(map.values());
                int max = Collections.max(countList);

                if (max > 1) {
                    for (String key : map.keySet()) {
                        if (max == map.get(key)) {
                            answer.add(key);
                        }
                    }
                }
            }
        }
        Collections.sort(answer);
        return answer.toArray(String[]::new);
    }

    public static void combination(String order, String other, int count,
                                   Map<String, Integer> map) {
        if (count == 0) {
            map.put(order, map.getOrDefault(order, 0) + 1);
            return;
        }
        for (int i = 0; i < other.length(); i++) {
            combination(order + other.charAt(i),
                    other.substring(i + 1), count - 1, map);
        }
    }


    public static void main(String[] args) {
        System.out.println(
                Arrays.toString(
                        solution(
                                new String[]{"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"},
                                new int[]{2, 3, 4}))
        );
    }

}
