import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws Exception {
    // 10
    // 1 5 2 1 4 3 4 5 2 1
    // 1 2 3 4 5 2 1

    // 세팅
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int size = Integer.parseInt(br.readLine());
    int[] numbers = new int[size];
    String[] inputs = br.readLine().split(" ");
    for (int i = 0; i < size; i++) {
      numbers[i] = Integer.parseInt(inputs[i]);
    }

    // 올라가는 바이토닉손의 길이
    int[] lis = new int[size];
    for (int i = 0; i < size; i++) {
      lis[i] = 1;
      for (int j = 0; j < i; j++) {
        if (numbers[j] < numbers[i] && lis[i] < lis[j] + 1) {
          lis[i] = lis[j] + 1;
        }
      }
    }

    // 내려가는 바이토닉손의 길이
    int[] lds = new int[size];
    for (int i = size - 1; i >= 0; i--) {
      lds[i] = 1;
      for (int j = size - 1; j > i; j--) {
        if (numbers[j] < numbers[i] && lds[i] < lds[j] + 1) {
          lds[i] = lds[j] + 1;
        }
      }
    }

//    System.out.println(Arrays.toString(numbers));
//    System.out.println(Arrays.toString(lis));
//    System.out.println(Arrays.toString(lds));

    int result = Integer.MIN_VALUE;
    for (int i = 0; i < size; i++) {
      result = Math.max(lis[i] + lds[i] - 1, result);
    }
    System.out.print(result);
  }
}
