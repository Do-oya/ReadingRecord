package item05;

import java.util.List;
import java.util.Objects;

public class SpellChecker_3 {
    private final Lexicon dictionary;

    public SpellChecker_3(Lexicon dictionary) {
        this.dictionary = Objects.requireNonNull(dictionary);
    }

    public static boolean isValid(String word) {
        return true;
    }

    public static List<String> suggest(String typo) {
        throw new UnsupportedOperationException();
    }
}
