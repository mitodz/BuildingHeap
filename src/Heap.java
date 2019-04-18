public class Heap {
    private int maxSize = Integer.MAX_VALUE;//реализовать увеличение массива при переполнении
    private int[] H = new int[maxSize];
    private int size;

    public Heap(int[] H) {
        System.arraycopy(H, 0, this.H, 0, H.length);
        size = H.length;
    }

    private void siftUp(int i) {
        while (i > 1 && H[parent(i)]<H[i]) {
            swap(i);
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

    private void insert(int p) {
        if (size==maxSize) {
            return;
        }
        size++;
        H[size] = p;
        siftUp(size);
    }

    private int extractMax(){
        int result = H[0];
        H[0] = H[size - 1];
        size--;
        siftDown(0);
        return result;
    }

    private void remove(int i) {
        H[i] = Integer.MAX_VALUE;
        siftUp(i);
        extractMax();
    }

    private void changePriority(int i, int p) {
        int oldP = H[i];
        H[i] = p;
        if (p>oldP) {
            siftUp(i);
        } else {
            siftDown(i);
        }
    }

    private void swap(int i) {
        int t = H[i];
        H[i] = H[parent(i)];
        H[parent(i)] = t;
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
