package algorithm.programmers.pccp;

/**
 * pccp 모의고사 1
 */
public class Solution_1 {
    public String solution(String input_string) {
        StringBuilder answer = new StringBuilder();
        int[] visit = new int[26];
        int size = input_string.length();
        for (int i = 0; i < size; i++) {
            char c = input_string.charAt(i);
            int index = c - 'a';
            if (i == 0) {
                visit[index]++;
            } else if (i > 0 && c != input_string.charAt(i - 1)) {
                visit[index]++;
            }
        }
        for (int i = 0; i < 26; i++) {
            if (visit[i] > 1) {
                char alpha = (char) (i + 'a');
                answer.append(alpha);
            }
        }
        if (answer.length() == 0) {
            return "N";
        }
        return answer.toString();
    }

    public static void main(String[] args) {
        Solution_1 sol = new Solution_1();
        sol.solution("edeaabcd");
    }
}
