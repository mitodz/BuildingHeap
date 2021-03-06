import java.util.Arrays;

public class HeapMax {
    private int maxSize = 20;//реализовать увеличение массива при переполнении
    private int[] H = new int[maxSize];
    private int size;

    private void siftUp(int i) {
        while (i > 0 && H[parent(i)]<H[i]) {
            swap(i, parent(i));
            i = parent(i);
        }
    }

    private void siftDown(int i) {
        int maxIndex = i;
        int l = left(i);
        if (l<=size && H[l] > H[maxIndex]) {
            maxIndex = l;
        }
        int r = right(i);
        if (r<=size && H[r]>H[maxIndex]) {
            maxIndex = r;
        }
        if (i!=maxIndex) {
            swap(i, maxIndex);
            siftDown(maxIndex);
        }
    }

    public void insert(int p) {
        if (size==maxSize) {
            H = Arrays.copyOf(H, maxSize * 3 / 2);
        }
        size++;
        H[size] = p;
        siftUp(size);
    }

    public int extractMax(){
        int result = H[0];
        H[0] = H[size - 1];
        size--;
        siftDown(0);
        return result;
    }

    public void remove(int i) {
        H[i] = Integer.MAX_VALUE;
        siftUp(i);
        extractMax();
    }

    public void changePriority(int i, int p) {
        int oldP = H[i];
        H[i] = p;
        if (p>oldP) {
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
        return (int) Math.floor((i - 1) / 2);
    }

    private int left(int i) {
        return 2 * i + 1;
    }

    private int right(int i) {
        return 2 * i + 2;
    }

}
