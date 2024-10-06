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
    public int[] parent;

    public int find(int x) {
        if(x == parent[x]) return x;
        else return parent[x] = find(parent[x]); //압축
    }

    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if(rootX != rootY) {
            parent[rootX] = rootY;
        }
    }

    public String solutionUnionFind(int target1, int target2) {
        parent = new int[studentNum + 1];

        for(int i = 1; i <= studentNum; i++) {
            parent[i] = i;
        }

        for(Friend friend : list) {
            union(friend.a, friend.b);
        }

        if(find(target1) == find(target2)) {
            return "YES";
        } else {
            return "NO";
        }
    }

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
        System.out.println(new Main().solutionUnionFind(sc.nextInt(), sc.nextInt()));
    }
}