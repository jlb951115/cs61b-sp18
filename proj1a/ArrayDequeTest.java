public class ArrayDequeTest {
    public static void main(String[] args){
        ArrayDeque<Integer> lld = new ArrayDeque<Integer>();
        lld.addLast(0);
        lld.addLast(1);
        lld.addFirst(2);
        lld.removeLast();
        lld.removeLast();
        int i = lld.get(0);
    }
}
