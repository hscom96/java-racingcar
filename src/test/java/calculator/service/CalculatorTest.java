package calculator.service;

import static org.assertj.core.api.Assertions.assertThat;

import calculator.domain.Formula;
import calculator.util.Operation;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class CalculatorTest {

    @Test
    void run(){
        String formula = "1 + 3 - 5";
        double result = Calculator.run(new Formula(formula));
        assertThat(result).isEqualTo(-1);
    }

    @Test
    void 더하기() {
        double result = Operation.PLUS.apply(3.0, 7.0);
        assertThat(result).isEqualTo(10.0);
    }

    @Test
    void 뺴기() {
        double result = Operation.MINUS.apply(7.0, 3.0);
        assertThat(result).isEqualTo(4.0);
    }

    @Test
    void 곱하기() {
        double result = Operation.TIMES.apply(7, 3);
        assertThat(result).isEqualTo(21.0);
    }

    @Test
    void 나누기() {
        double result = Operation.DIVDE.apply(6.0, 3.0);
        assertThat(result).isEqualTo(2.0);
    }
}