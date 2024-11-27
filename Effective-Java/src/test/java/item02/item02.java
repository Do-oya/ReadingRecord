package item02;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static item02.NyPizza.Size.SMALL;
import static item02.Pizza.Topping.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DisplayName("아이템 2. 생성자에 매개변수가 많다면 빌더를 고려하라")
public class item02 {

    @Test
    @DisplayName("점층적 생성자 패턴 - 확장하기 어렵다.")
    void item02_test_1() {
        NutritionFacts_1 cocaCola = new NutritionFacts_1(240, 8, 100, 0, 35, 27);
        verifyNutritionFacts(cocaCola);
    }

    @Test
    @DisplayName("자바빈즈 패턴 - 일관성이 깨지고, 불변으로 만들 수 없다.")
    void item02_test_2() {
        NutritionFacts_2 cocaCola = new NutritionFacts_2();
        cocaCola.setServingSize(240);
        cocaCola.setServings(8);
        cocaCola.setCalories(100);
        cocaCola.setSodium(35);
        cocaCola.setCarbohydrate(27);
        verifyNutritionFacts(cocaCola);
    }

    @Test
    @DisplayName("빌더 패턴 - 점층적 생성자 패턴과 자바빈즈 패턴의 장점만 취했다.")
    void item02_test_3() {
        NutritionFacts_3 cocaCola = new NutritionFacts_3.Builder(240, 8)
                .calories(100).sodium(35).carbohydrate(27).build();
        verifyNutritionFacts(cocaCola);
    }

    @Test
    @DisplayName("게층적으로 설계된 클래스와 잘 어울리는 빌더 패턴")
    void item02_test_4() {
        NyPizza pizza = new NyPizza.Builder(SMALL)
                .addTopping(SAUSAGE).addTopping(ONION).build();
        Calzone calzone = new Calzone.Builder()
                .addTopping(HAM).sauceInside().build();
        assertThat(pizza).isInstanceOf(NyPizza.class);
        assertThat(calzone).isInstanceOf(Calzone.class);
    }

    private static void verifyNutritionFacts(NutritionFacts nutritionFacts) {
        assertThat(nutritionFacts).isNotNull();
        assertThat(nutritionFacts.getServingSize()).isEqualTo(240);
        assertThat(nutritionFacts.getServings()).isEqualTo(8);
        assertThat(nutritionFacts.getCalories()).isEqualTo(100);
        assertThat(nutritionFacts.getFat()).isEqualTo(0);
        assertThat(nutritionFacts.getSodium()).isEqualTo(35);
        assertThat(nutritionFacts.getCarbohydrate()).isEqualTo(27);
    }
}
