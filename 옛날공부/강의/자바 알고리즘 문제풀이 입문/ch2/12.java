import java.util.*;

class Main {

    public boolean canMento(int[] arr, int size, int mento, int menti) {
        int mentoIndex = -1;
        int mentiIndex = -1;
        for(int i = 0; i < size; i++) {
            if(arr[i] - 1 == mento) mentoIndex = i;
            if(arr[i] - 1 == menti) mentiIndex = i;
        }
        
        return  (mentoIndex < mentiIndex) && (mento != menti);
    }

    public int solution(int stuNum, int testNum, int[][] testResult) {
        
        int pairNum = 0;

        for(int mento = 0; mento < stuNum; mento++) {
            for(int menti = 0; menti < stuNum; menti++) {
                boolean canPair = true;
                for(int t = 0; t < testNum; t++) {
                    if(!canMento(testResult[t], stuNum, mento, menti)) {
                        canPair = false;
                        break;
                    }
                }
                if(canPair) {
                    pairNum++;
                }
            }
        }

        return pairNum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int stuNum = sc.nextInt();
        int testNum = sc.nextInt();

        int[][] testResult = new int[testNum][stuNum];
        for(int test = 0; test < testNum; test++) {
            for(int stu = 0; stu < stuNum; stu++) {
                testResult[test][stu] = sc.nextInt();
            }
        }

        Main T = new Main();
        int result = T.solution(stuNum, testNum, testResult);
        System.out.println(result);
    }
}