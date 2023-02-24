public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
            Deque<Character> D = new ArrayDeque<Character>();
            for (int i = 0; i < word.length(); i++){
                D.addLast(word.charAt(i));
            }
            return D;
        }

    public boolean isPalindrome(String word){
        Palindrome P = new Palindrome();
        Deque<Character> D = P.wordToDeque(word);
        for (int i = 0; i < D.size()/2; i++){
            if (D.get(i) != D.get(D.size() - 1 - i)){
                return false;
            }
        }
        return  true;
    }

    public boolean isPalindrome(String word, CharacterComparator cc){
        Palindrome P = new Palindrome();
        Deque<Character> D = P.wordToDeque(word);
        for (int i = 0; i < D.size()/2; i++){
            if (!cc.equalChars(D.get(i), D.get(D.size() - 1 - i))){
                return false;
            }
        }
        return  true;
    }
}
