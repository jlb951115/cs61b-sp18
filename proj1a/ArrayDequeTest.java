public class ArrayDequeTest {
    public static void main(String[] args){
        ArrayDeque<Integer> lld = new ArrayDeque<Integer>();
        lld.addLast(0);
        int i = lld.removeFirst();
        lld.addLast(2);
        i = lld.removeLast();
        lld.addLast(4);
        i = lld.removeLast();
        lld.addLast(6);
        i = lld.get(0);
    }
}
