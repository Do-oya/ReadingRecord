package chapter6.item35;

public enum Ensemble_1 {
    SOLO, DUEF, TRIO, QUARTET, QUINTET,
    SEXTET, SEPTET, OCTET, NONET, DECTET;

    public int numberOfMusicians() {
        return ordinal() + 1;
    }
}