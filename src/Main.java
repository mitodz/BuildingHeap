import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner("31\n" +
                "31 30 29 28 27 26 25 24 23 22 21 20 19 18 17 16 15 14 13 12 11 10 9 8 7 6 5 4 3 2 1");
        int n = scanner.nextInt();
        HeapMin h = new HeapMin();
        for (int i = 0; i < n; i++) {
            h.insert(scanner.nextInt());
        }
        h.buildHeap();
        int count = h.getCount();
        System.out.println(count);
        System.out.println(h.getSb());
    }
}
