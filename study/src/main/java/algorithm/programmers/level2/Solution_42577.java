package algorithm.programmers.level2;

import java.util.Arrays;

/**
 * 문제 링크 : https://programmers.co.kr/learn/courses/30/lessons/42577
 * 전화번호 목록
 */
public class Solution_42577 {

    public static boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);
        int size = phone_book.length;
        for (int i = 0; i < size - 1; i++) {
                if (phone_book[i + 1].startsWith(phone_book[i])) return false;
        }
        return true;
    }


    public static void main(String[] args) {
        String[] test = {"119", "97674223", "1195524421", "2"};
        solution(test);
    }
}
