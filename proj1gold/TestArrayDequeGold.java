import static org.junit.Assert.*;
import org.junit.Test;
public class TestArrayDequeGold {
    @Test
    public void Teststudent() {
        StudentArrayDeque<Integer> actual = new StudentArrayDeque<Integer>();
        ArrayDequeSolution<Integer> expected = new ArrayDequeSolution<Integer>();
        String s = "";
        int lowerbounbder = 5;
        for(int i = 0; i < 10; i++){
            double number = StdRandom.uniform();
            int x = StdRandom.uniform(lowerbounbder, lowerbounbder+5);
            if (number >= 0.5){
                s += "addFirst(" + x + ")" + "\n";
                actual.addFirst(x);
                expected.addFirst(x);
            } else {
                s += "addLast(" + x + ")" + "\n";
                actual.addLast(x);
                expected.addLast(x);
            }
            lowerbounbder += 5;
        }
        s += "size()\n";
        assertEquals(s, expected.size(), actual.size());
        while(expected.size() != 0){
            double number = StdRandom.uniform();
            if (number >= 0.5){
                int x = expected.removeFirst();
                int y = actual.removeFirst();
                s += "removeFirst()\n";
                assertEquals(s, x, y);
            } else {
                int x = expected.removeLast();
                int y = actual.removeLast();
                s += "removeLast()\n";
                assertEquals(s, x, y);
            }
        }
    }
}
