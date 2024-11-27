package item05;

import java.util.List;

public class SpellChecker_1 {
    private static final Lexicon dictionary = new KoreanDicationry();

    private SpellChecker_1() {
    }

    public static boolean isValid(String word) {
        return true;
    }

    public static List<String> suggest(String typo) {
        throw new UnsupportedOperationException();
    }
}

interface Lexicon {}

class KoreanDicationry implements Lexicon {}
