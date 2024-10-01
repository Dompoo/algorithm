class Main {

    public int solution(int size, int dvd, int[] arr) {

        /*
        9 3
        1 2 3 4 5   15
        6 7         13
        8 9         17

        45 / 3 = 15
        */

        return 100;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int dvd = sc.nextInt();
        int[] arr = new int[size];
        for(int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(new Main().solution(size, dvd, arr));
    }
}