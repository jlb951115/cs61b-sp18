public class OffByN implements CharacterComparator{

    private int num;

    public OffByN(int x){
        num = x;
    }
    @Override
    public boolean equalChars(char x, char y) {
        int i = x - y;
        if (Math.abs(i) == num){
            return true;
        }else{
            return false;
        }
    }
}
