package chapter5.item33;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("아이템 33. 타입 안전 이종 컨테이너를 고려하라")
public class Item33 {

    @Test
    @DisplayName("타입 안전 이종 컨테이너 패턴 - API, 클라이언트")
    void item33_test_1() {
        Favorites f = new Favorites();

        f.putFavorite(String.class, "Java");
        f.putFavorite(Integer.class, 0xcafebabe);
        f.putFavorite(Class.class, Favorites.class);

        String favoriteString = f.getFavorite(String.class);
        int favoriteInteger = f.getFavorite(Integer.class);
        Class<?> favoriteClass = f.getFavorite(Class.class);
    }
}
