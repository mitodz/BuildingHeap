import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
    Scanner scanner = new Scanner("5\n" +
            "5 4 3 2 1");
    int n = scanner.nextInt();
    HeapMin h = new HeapMin();
        for (int i = 0; i < n; i++) {
            h.insert(scanner.nextInt());
        }
        h.buildHeap();
        int count = h.getCount();
        System.out.println(count);
        System.out.println(h.getSb());
        for (int i = 0; i < n; i++) {
            System.out.print(h.extractMin() + " ");
        }
    }
}
