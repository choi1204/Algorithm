package algorithm.programmers.level2;

public class Solution_84512 {
    public int solution(String word) {
        int answer = word.length();
        char[] words = {'A', 'E', 'I', 'O', 'U'};
        int[] level = {781, 156, 31, 6, 1};

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int j = 0;
            for (; j < 5; j++) {
                if (c == words[j]) {
                    break;
                }
            }
            answer += j * level[i];
        }
        return answer;
    }
}
