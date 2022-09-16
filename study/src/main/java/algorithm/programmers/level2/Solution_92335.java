package algorithm.programmers.level2;

/**
 * k진수에서 소수 개수 구하기
 * https://school.programmers.co.kr/learn/courses/30/lessons/92335
 */
public class Solution_92335 {

    public int solution(int n, int k) {
        int answer = 0;
        String number = Integer.toString(n, k);
        String[] split = number.split("0");
        for (String s : split) {
            if (s.equals("")) {
                continue;
            }
            long checkNumber = Long.parseLong(s);
            if (isPrime(checkNumber)) {
                answer++;
            }
        }
        return answer;
    }

    public boolean isPrime (long a){

        if(a<2) return false;

        for(int i=2;i<=Math.sqrt(a);i++){
            if(a%i==0){
                return false;
            }
        }
        return true;
    }

}
