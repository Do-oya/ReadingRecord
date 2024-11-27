package item05;

import java.util.List;

public class SpellChecker_2 {
    private final Lexicon dictionary = new KoreanDicationry();

    private SpellChecker_2() {
    }

    public static final SpellChecker_2 INSTANCE = new SpellChecker_2();

    public static boolean isValid(String word) {
        return true;
    }

    public static List<String> suggest(String typo) {
        throw new UnsupportedOperationException();
    }
}
