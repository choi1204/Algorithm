package algorithm.programmers.level3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 문제 링크 : https://programmers.co.kr/learn/courses/30/lessons/42579
 * 베스트앨범
 */
public class Solution_42579 {

    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> map = new HashMap<>();
        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < genres.length; i++) {
            map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);
        }
        List<String> highGenreList = new ArrayList<>(map.keySet());
        highGenreList.sort((value1, value2) -> map.get(value2).compareTo(map.get(value1)));

        for (String genre : highGenreList) {
            int max = 0;
            int firstIndex = -1;
            int secondIndex = -1;
            for (int i = 0; i < genres.length; i++) {
                if (!genres[i].equals(genre) || plays[i] <= max)
                    continue;
                max = plays[i];
                firstIndex = i;
            }
            max = 0;
            for (int i = 0; i < genres.length; i++) {
                if (!genres[i].equals(genre) || plays[i] < max || i == firstIndex)
                    continue;
                max = plays[i];
                secondIndex = i;
            }
            answer.add(firstIndex);
            if (secondIndex != -1) answer.add(secondIndex);
        }
        return answer.stream().mapToInt(i -> i).toArray();
    }
}
