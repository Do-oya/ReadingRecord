package toby.springbook.template;

import org.junit.jupiter.api.Test;
import toby.springbook.user.template.Calculator;

import java.io.IOException;

import static org.assertj.core.api.Assertions.*;

public class CalcSumTest {
    @Test
    public void sumOfNumbers() throws IOException {
        Calculator calculator = new Calculator();
        String path = getClass().getResource("/numbers.txt").getPath();
        int sum = calculator.calcSum(path);
        assertThat(sum).isEqualTo(10);
    }
}
