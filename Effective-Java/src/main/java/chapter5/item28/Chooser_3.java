package chapter5.item28;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Chooser_3<T> {
    private final List<T> choiceList;

    public Chooser_3(List<T> choices) {
        choiceList = new ArrayList<>(choices);
    }

    public T chose() {
        Random rnd = ThreadLocalRandom.current();
        return choiceList.get(rnd.nextInt(choiceList.size()));
    }
}
