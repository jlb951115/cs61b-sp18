public class OffByOne implements CharacterComparator {
    @Override
    public boolean equalChars(char x, char y) {
        int i = x - y;
        return Math.abs(i) == 1;
    }
}
