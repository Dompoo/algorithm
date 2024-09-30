import java.util.*;

// 선택 정렬 구현
class Main {

    public String solution(int size, int[] arr) {
        List<Integer> resultList = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        for(int i = 0; i < size; i++) {
            list.add(arr[i]);
        }

        while(resultList.size() < size) {
            // 현재 가장 큰 것을 고르기
            int min = Integer.MAX_VALUE;
            int minIndex = 0;
            for(int i = 0; i < list.size(); i++) {
                if(list.get(i) <= min) {
                    min = list.get(i);
                    minIndex = i;
                }
            }

            // 그것을 넣기
            resultList.add(min);
            list.remove(minIndex);
        }

        // 출력부
        String result = "";
        for(int i = 0; i < resultList.size(); i++) {
            result += resultList.get(i);
            if(i != resultList.size() - 1) {
                result += " ";
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] arr = new int[size];
        for(int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(new Main().solution(size, arr));
    }
}