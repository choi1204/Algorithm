package algorithm.programmers.level1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
    문제 링크 : https://programmers.co.kr/learn/courses/30/lessons/92334?language=java
    문제 제목 : 신고 결과 받기

 */
public class Solution_92334 {

    public static int[] solution(String[] id_list, String[] report, int k) {

        Map<String, Integer> indexMap = new HashMap<>();
        Map<Integer, List<Integer>> accuserMap = new HashMap<>();
        int[] answer = new int[id_list.length];

        for (int i=0; i< id_list.length; i++) {
            indexMap.put(id_list[i], i);
            accuserMap.put(i, new ArrayList());
        }

        for (String s : report) {
            String[] ids = s.split(" ");
            String accuser = ids[0];
            String defendant = ids[1];
            int accuserIndex = indexMap.get(accuser);
            int defendantIndex = indexMap.get(defendant);
            List<Integer> accuserList = accuserMap.get(defendantIndex);
            if(!accuserList.contains(accuserIndex)) {
                accuserList.add(accuserIndex);
            }
        }

        for (int i = 0; i < id_list.length; i++) {
            List<Integer> accuserList = accuserMap.get(i);
            if (accuserList.size() >= k) {
                accuserList.stream().forEach(index -> answer[index]++);
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        System.out.println(solution(id_list, report, 3));
    }

}
