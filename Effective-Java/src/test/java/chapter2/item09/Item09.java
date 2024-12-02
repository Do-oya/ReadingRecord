package chapter2.item09;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@DisplayName("아이템 9. try-finally보다는 try-with-resources를 사용하라")
public class Item09 {

    @Test
    @DisplayName("try-finally - 더 이상 자원을 회수하는 최선의 방책이 아니다!")
    void item09_test_1() throws IOException {
        String path = "Test";
        assertThat(path).isEqualTo(TopLine.firstLineOfString_1(path));
    }

    @Test
    @DisplayName("자원이 둘 이상이면 try-finally 방식은 너무 지저분하다!")
    void item09_test_2() throws IOException {
        String src = "Test";
        String result = Copy.copy_1(src);
        assertThat(src).isEqualTo(result);
    }

    @Test
    @DisplayName("try-with-resources - 자원을 회수하는 최선책!")
    void item09_test_3() throws IOException {
        String path = "Test";
        assertThat(path).isEqualTo(TopLine.firstLineOfString_2(path));
    }

    @Test
    @DisplayName("복수의 자원을 처리하는 try-with-resources - 짧고 매혹적이다!")
    void item09_test_4() throws IOException {
        String src = "Test";
        String result = Copy.copy_2(src);
        assertThat(src).isEqualTo(result);
    }
}
