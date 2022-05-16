package algorithm.programmers.level1;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 문제 링크 : https://programmers.co.kr/learn/courses/30/lessons/42748
 * 전화번호 목록
 */
public class Solution_42748 {
    public static int[] solution(int[] array, int[][] commands) {
        List<Integer> answer = new ArrayList<>();
        List<Integer> arr = Arrays.stream(array).boxed().collect(Collectors.toList());

        for (int[] list : commands) {
            int start = list[0];
            int end = list[1];
            int target = list[2] - 1;

            List<Integer> subList = new ArrayList<>(arr.subList(start - 1, end));
            Collections.sort(subList);
            answer.add(subList.get(target));
        }
        return answer.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        int[] arr = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
        solution(arr, commands);
    }
}
