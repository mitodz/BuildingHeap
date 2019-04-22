import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Random rnd = new Random();
        HeapMin heapMin = new HeapMin();
        for (int i = 0; i < 10; i++) {
            heapMin.insert((int)(rnd.nextDouble()*100));
        }
        for (int i = 0; i < 10; i++) {
            System.out.print(heapMin.extractMin() + " ");
        }
    }
}
