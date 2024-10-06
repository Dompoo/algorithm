import java.util.*;

class Main {

    static class Friend {
        int a;
        int b;
        Friend(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }

    public static int studentNum;
    public static int size;
    public static List<Friend> list = new ArrayList<>();

    public String solution(int target1, int target2) {
        int[] group = new int[studentNum + 1];
        int gNum = 0;

        for(Friend friend : list) {
            int a = friend.a;
            int b = friend.b;
            if(group[a] == 0 && group[b] == 0) {
                group[a] = gNum;
                group[b] = gNum;
                gNum++;
            } else if(group[a] == 0 && group[b] != 0) {
                group[a] = group[b];
            } else if(group[a] != 0 && group[b] == 0) {
                group[b] = group[a];
            } else {
                int mergeGroup = group[a];
                for(int i = 1; i <= studentNum; i++) {
                    if(group[i] == mergeGroup) {
                        group[i] = group[b];
                    }
                }
            }
        }

        if(group[target1] != 0 && group[target2] != 0 && group[target1] == group[target2]) {
            return "YES";
        } else {
            return "NO";
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        studentNum = sc.nextInt();
        size = sc.nextInt();
        for(int i = 0; i < size; i++) {
            list.add(new Friend(sc.nextInt(), sc.nextInt()));
        }
        System.out.println(new Main().solution(sc.nextInt(), sc.nextInt()));
    }
}