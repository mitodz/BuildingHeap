public class Heap {



    public long parent(long i) {
        return (long) Math.floor((i - 1) / 2);
    }

    public long left(long i) {
        return 2 * i + 1;
    }

    public long right(long i) {
        return 2 * i + 2;
    }

}
