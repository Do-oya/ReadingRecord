package chapter2.item02;

public class NutritionFacts_1 implements NutritionFacts {
    private final int servingSize;
    private final int servings;
    private final int calories;
    private final int fat;
    private final int sodium;
    private final int carbohydrate;

    public NutritionFacts_1(int servingSize, int servings) {
        this(servingSize, servings, 0);
    }

    public NutritionFacts_1(int servingSize, int servings, int calories) {
        this(servingSize, servings, calories, 0);
    }

    public NutritionFacts_1(int servingsSize, int servings, int calories, int fat) {
        this(servingsSize, servings, calories, fat, 0);
    }

    public NutritionFacts_1(int servingsSize, int servings, int calories, int fat, int sodium) {
        this(servingsSize, servings, calories, fat, sodium, 0);
    }

    public NutritionFacts_1(int servingSize, int servings, int calories, int fat, int sodium, int carbohydrate) {
        this.servingSize = servingSize;
        this.servings = servings;
        this.calories = calories;
        this.fat = fat;
        this.sodium = sodium;
        this.carbohydrate = carbohydrate;
    }

    public int getServingSize() {
        return servingSize;
    }

    public int getServings() {
        return servings;
    }

    public int getCalories() {
        return calories;
    }

    public int getFat() {
        return fat;
    }

    public int getSodium() {
        return sodium;
    }

    public int getCarbohydrate() {
        return carbohydrate;
    }
}
