package algorithm.test.devcos;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution_11447 {

    static class Notification {
        Stack<String> noti = new Stack<>();
        List<String> storage = new ArrayList<>();

        void push(String name, String state) {
            if (state.equals("comment")) {
                state = "commented on your post";
            } else if (state.equals("share")) {
                state = "shared your post";
            }

            if (noti.empty()) {
                noti.push(name + " " + state);
            } else if (noti.lastElement().contains(state) && noti.lastElement().contains("others")) {
                String[] split = noti.pop().split(" ");
                String highName = split[0];
                int N = Integer.parseInt(split[2]) + 1;
                noti.push(highName + " and " + N + " others " + state);
            } else if (noti.lastElement().contains(state) && noti.lastElement().contains("and")) {
                String[] split = noti.pop().split(" ");
                String highName = split[0];
                noti.push(highName + " and 2 " + "others " + state);
            } else if (noti.lastElement().contains(state)) {
                String[] split = noti.pop().split(" ");
                String highName = split[0];
                noti.push(highName + " and " + name + " " + state);
            } else {
                noti.push(name + " " + state);
            }
        }
        void check() {
            String high = noti.pop();
            storage.add(high);
        }
        List<String> getStorage() {
            return this.storage;
        }


    }
    public static String[] solution(String[] records) {
        Notification notification = new Notification();
        for (String s : records) {
            String[] split = s.split(" ");
            String name = split[0];
            String state = split[1];
            if (state.equals("notification")) {
                notification.check();
            } else {
                notification.push(name, state);
            }
        }
        List<String> storage = notification.getStorage();
        String[] answer = storage.toArray(new String[storage.size()]);
        return answer;
    }

    public static void main(String[] args) {
        String[] records = {"john share", "mary comment", "jay share", "check notification", "check notification", "sally comment", "james share", "check notification", "lee share", "laura share", "will share", "check notification", "alice comment", "check notification"};
        String[] records2 = {"john share", "mary share", "jay share", "james comment", "lee share", "check notification", "sally comment", "laura comment", "check notification", "will share", "ruby share", "check notification"};
        System.out.println(solution(records2));
        int a = 1;
    }
}
