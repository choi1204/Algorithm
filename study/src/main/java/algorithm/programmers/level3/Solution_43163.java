package algorithm.programmers.level3;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * 단어변환
 * https://school.programmers.co.kr/learn/courses/30/lessons/43163
 */
public class Solution_43163 {
    class Word {
        String str;
        int change;
        public Word(String str, int change) {
            this.str = str;
            this.change = change;
        }
    }
    public int solution(String begin, String target, String[] words) {
        return bfs(begin, target, words);
    }
    public int bfs(String begin, String target, String[] words) {
        Queue<Word> queue = new LinkedList<>();
        Set<String> stringSet = new HashSet<>();
        queue.add(new Word(begin, 0));
        while(!queue.isEmpty()) {
            Word now = queue.poll();
            stringSet.add(now.str);
            if (now.str.equals(target)) {
                return now.change;
            }
            for (String word : words) {
                if (isChange(now.str, word) && !stringSet.contains(word)) {
                    queue.add(new Word(word, now.change + 1));
                }
            }
        }
        return 0;
    }
    boolean isChange(String str, String word) {
        int count = 0;
        for (int i = 0; i < word.length(); i++) {
            if (!(word.charAt(i) == str.charAt(i))) {
                count++;
            }
            if (count == 2) {
                return false;
            }
        }
        return true;
    }
}
