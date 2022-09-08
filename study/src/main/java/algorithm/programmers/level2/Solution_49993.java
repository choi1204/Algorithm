package algorithm.programmers.level2;

public class Solution_49993 {

    public static int solution(String skill, String[] skill_trees) {
        int answer = 0;
        for(String tech : skill_trees) {
            int length = skill.length();
            boolean[] skillArr = new boolean[length + 1];
            boolean check = true;
            skillArr[0] = true;

            for (int i = 0; i < tech.length(); i++) {
                char c = tech.charAt(i);
                if (skill.contains(String.valueOf(c))) {
                    int index = skill.indexOf(c);
                    if (skillArr[index]) {
                        skillArr[index + 1] = true;
                    }
                    else {
                        check = false;
                        break;
                    }
                }
            }

            answer = check ? answer + 1 : answer;
        }

        return answer;
    }

    public static void main(String[] args) {
        String skill = "CBD";
        String[] skillTrees = { "BACDE", "CBADF", "AECB", "BDA" };
        System.out.println(solution(skill,skillTrees));
    }
}
