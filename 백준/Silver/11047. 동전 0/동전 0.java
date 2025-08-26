import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
3 4
baesangwook
ohhenrie
charlie
obama
baesangwook
ohhenrie
clinton
 */
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs = br.readLine().split(" ");
        int coinTypeCount = Integer.parseInt(inputs[0]);
        int target = Integer.parseInt(inputs[1]);

        int[] coinType = new int[coinTypeCount];
        for (int i = 0; i < coinTypeCount; i++) {
            coinType[i] = Integer.parseInt(br.readLine());
        }

        int coinCount = 0;
        int currentCoinTypeIndex = coinTypeCount - 1;
        while (target > 0) {
            int currentType = coinType[currentCoinTypeIndex];
            if (currentType > target) {
                currentCoinTypeIndex--;
            } else {
                target -= currentType;
                coinCount++;
            }
        }
        System.out.print(coinCount);
    }
}
