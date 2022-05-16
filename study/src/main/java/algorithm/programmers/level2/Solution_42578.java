package algorithm.programmers.level2;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 문제 링크 : https://programmers.co.kr/learn/courses/30/lessons/42578
 * 위장
 */
public class Solution_42578 {
    public static int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < clothes.length; i++) {
            String kinds   = clothes[i][1];
            map.put(kinds, map.getOrDefault(kinds,0) + 1);
        }
        for (String kind : map.keySet()) {
            int size = map.get(kind);
            answer *= size + 1;
        }


        return answer - 1;
    }

    public static void main(String[] args) {
        String[][] test ={{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}};
        solution(test);
    }
}
