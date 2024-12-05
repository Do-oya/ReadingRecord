package chapter4.item25;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DisplayName("톱레밸 클래스는 한 파일에 하나만 담으라")
public class Item25 {

    @Test
    @DisplayName("두 클래스가 한 파일에 정의되었다 - 따라하지 말 것!")
    void item25_test_1() {
        assertThat("pancake").isEqualTo(Utensil.NAME + Dessert.NAME);
    }

    @Test
    @DisplayName("톱레벨 클래스들을 정적 멤버 클래스로 바꿔본 모습")
    void item25_test_2() {
        assertThat("pancake").isEqualTo(chapter4.item25.Test.Utensil.NAME + chapter4.item25.Test.Dessert.NAME);
    }
}
