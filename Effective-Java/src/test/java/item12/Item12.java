package item12;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("아이템 12. toString을 항상 재정의하라")
public class Item12 {

    @Test
    void item12_test_1() {
        PhoneNumber phoneNumber = new PhoneNumber(707, 867, 5309);
        System.out.println(phoneNumber);
    }
}
