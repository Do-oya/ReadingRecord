package chapter6.item37;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

@DisplayName("아이템 37. ordinal 인덱싱 대신 EnumMap을 사용하라")
public class Item37 {

    @Test
    @DisplayName("ordinal()을 배열 인덱스로 사용 - 따라 하지 말 것!")
    void item37_test_1() {
        Plant[] garden = getPlants();
        Set<Plant>[] plantsByLifeCycleArr = (Set<Plant>[]) new Set[Plant.LifeCycle.values().length];
        for (int i = 0; i < plantsByLifeCycleArr.length; i++)
            plantsByLifeCycleArr[i] = new HashSet<>();
        for (Plant p : garden)
            plantsByLifeCycleArr[p.lifeCycle.ordinal()].add(p);
        for (int i = 0; i < plantsByLifeCycleArr.length; i++) {
            System.out.printf("%s: %s%n",
                    Plant.LifeCycle.values()[i], plantsByLifeCycleArr[i]);
        }
    }

    @Test
    @DisplayName("EnumMap을 사용해 데이터와 열거 타입을 매핑한다.")
    void item37_test_2() {

    }

    private static Plant[] getPlants() {
        Plant[] garden = {
                new Plant("바질",    Plant.LifeCycle.ANNUAL),
                new Plant("캐러웨이", Plant.LifeCycle.BIENNIAL),
                new Plant("딜",      Plant.LifeCycle.ANNUAL),
                new Plant("라벤더",   Plant.LifeCycle.PERENNIAL),
                new Plant("파슬리",   Plant.LifeCycle.BIENNIAL),
                new Plant("로즈마리", Plant.LifeCycle.PERENNIAL)
        };
        return garden;
    }
}
