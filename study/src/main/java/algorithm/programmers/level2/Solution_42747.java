//package algorithm.programmers.level2;
//
//import java.util.Arrays;
//
///**
// * 문제 링크 : https://programmers.co.kr/learn/courses/30/lessons/42747
// * HIndex
// */
//public class Solution_42747 {
//    public static int solution(int[] citations) {
//        int answer = 0;
//        Arrays.sort(citations);
//        for (int i = 0; i < citations.length; i++) {
//            int count = 0;
//            for (int j = 0; j < citations.length; j++) {
//                if (j < i)
//                    break;
//                count++;
//            }
//            if (count )
//        }
//        return answer;
//    }
//
//    public static void main(String[] args) {
//        int[] num = {3, 0, 6, 1, 5};
//        solution(num);
//    }
//}
