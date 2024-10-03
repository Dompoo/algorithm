import java.util.*;

class Main {

    public static int x;
    public static int y;
    public static int[][] arr;
    public int[] dx = new int[] {0, 0, 1, -1};
    public int[] dy = new int[] {1, -1, 0, 0};

    // 토마토가 더 익는다면 Point가 증가할 것
    public int getTomatoPoint(int[][] tomato) {
        int sum = 0;
        for(int i = 0; i < x; i++) {
            for(int j = 0; j < y; j++) {
                sum += tomato[i][j];
            }
        }
        return sum;
    }

    public int solution() {
        int prevPoint = getTomatoPoint(arr);
        int currPoint = prevPoint;
        int days = 0;
        int result = 0;

        while(true) {
            // for(int i = 0; i < x; i++) {
            //     for(int j = 0; j < y; j++) {
            //         System.out.printf("%2d", arr[i][j]);
            //     }
            //     System.out.println();
            // }
            // System.out.println();

            //토마토를 익게 만들기
            for(int i = 0; i < x; i++) {
                for(int j = 0; j < y; j++) {
                    //익은 토마토라면
                    if(arr[i][j] == 1) {
                        //토마토 전파
                        for(int k = 0; k < 4; k++) {
                            int di = i + dx[k];
                            int dj = j + dy[k];
                            if(0 <= di && di < x && 0 <= dj && dj < y && arr[di][dj] == 0) {
                                arr[di][dj] = 2;
                                currPoint++;
                            }
                        }
                    }
                }
            }

            //모두 충분히 익기 완료
            if(prevPoint == currPoint) {
                boolean isAllIkem = true;
                for(int i = 0; i < x; i++) {
                    for(int j = 0; j < y; j++) {
                        if(arr[i][j] == 0) {
                            isAllIkem = false;
                            break;
                        }
                    }
                }

                if(isAllIkem) {
                    //그것이 아니라면 days
                    result = days;
                } else {
                    //안익은 것이 있다면 -1
                    result = -1;
                }
                break;
            } else {
                for(int i = 0; i < x; i++) {
                    for(int j = 0; j < y; j++) {
                        if(arr[i][j] == 2) {
                            arr[i][j] = 1;
                        }
                    }
                }
                prevPoint = currPoint;
                days++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        y = sc.nextInt();
        x = sc.nextInt();
        arr = new int[x][y];
        for(int i = 0; i < x; i++) {
            for(int j = 0; j < y; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.println(new Main().solution());
    }
}