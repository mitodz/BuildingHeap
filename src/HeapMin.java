import java.util.Arrays;

public class HeapMin {
    private int maxSize = 20;//реализовать увеличение массива при переполнении
    private int[] H = new int[maxSize];
    private int size = -1;
    StringBuilder sb = new StringBuilder(); //для хранения пар обменов
    private int count = 0; // счётчик для обменов
    private int e=-1; // счётчик для неверных расположений


    private void siftUp(int i) {
        while (i > 0 && H[parent(i)] > H[i]) {
            swap(i, parent(i));
            sb.append(parent(i)).append(" ").append(i).append("\n");
            count++;
            e++;
            i = parent(i);
        }
    }

    private void siftDown(int i) {
        int minIndex = i;
        int l = left(i);
        if (l <= size && H[l] < H[minIndex]) {
            minIndex = l;
        }
        int r = right(i);
        if (r <= size && H[r] < H[minIndex]) {
            minIndex = r;
        }
        if (i != minIndex) {
            swap(i, minIndex);
            siftDown(minIndex);
        }
    }

    public void insert(int p) {
        if (size == maxSize) {
            H = Arrays.copyOf(H, maxSize * 3 / 2);
        }
        size++;
        H[size] = p;
        //siftUp(size); реализовать ПРЕВРАЩЕНИЕ обычного массива в мин кучу
    }

    public void buildHeap() {
        while (e!=0) {
            e=0;
            for (int i = size; i > 0; i--) {
                siftUp(i);
            }
        }
    }

    public int extractMin() {
        int result = H[0];
        H[0] = H[size];
        size--;
        siftDown(0);
        return result;
    }

    public void remove(int i) {
        H[i] = Integer.MIN_VALUE;
        siftUp(i);
        extractMin();
    }

    public void changePriority(int i, int p) {
        int oldP = H[i];
        H[i] = p;
        if (p < oldP) {
            siftUp(i);
        } else {
            siftDown(i);
        }
    }

    private void swap(int i, int j) {
        int t = H[i];
        H[i] = H[j];
        H[j] = t;
    }

    private int parent(int i) {
        return (i - 1) / 2;
    }

    private int left(int i) {
        return 2 * i + 1;
    }

    private int right(int i) {
        return 2 * i + 2;
    }

    public String getSb() {
        return sb.toString();
    }

    public int getCount() {
        return count;
    }
}
