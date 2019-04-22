import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Random rnd = new Random();
	Heap heap = new Heap();
        for (int i = 0; i < 10; i++) {
            heap.insert((int)(rnd.nextDouble()*100));
        }
        for (int i = 0; i < 10; i++) {
            System.out.print(heap.extractMax() + " ");
        }
    }
}
