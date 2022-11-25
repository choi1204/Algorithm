//package algorithm.programmers.pccp;
//
///**
// * pccp 모의고사 3
// * https://school.programmers.co.kr/learn/courses/15008/lessons/121685
// */
//public class Solution_3 {
//    int[] check = {0 , 1, 1, 2};
//    public String[] solution(int[][] queries) {
//        StringBuilder answer = new StringBuilder();
//        for (int i = 0; i < queries.length; i++) {
//            int n = queries[i][0];
//            int p = queries[i][1];
//            answer.append(get(n, p) + ",");
//        }
//
//        return answer.substring(0, answer.length() - 1).split(",");
//    }
//
//    private int get(int n, int p) {
//
//        int nextN = p / 4;
//        int nextP = p % 4;
//        String s = get(nextN, nextP);
//
//        return s;
//    }
//
//    private String parse(int num) {
//        switch (num) {
//            case 0: return "RR";
//            case 1:
//            case 2: return "Rr";
//            case 3: return "rr";
//        }
//    }
//}
