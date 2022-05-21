package pl.sdacademy.unit.test.advance.exercises.task1;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @ParameterizedTest
    @MethodSource("provideDataForAddMethod")
    void shouldAddTwoValues(int firstDigit, int secondDigit, long expectedResult) {
        //given
        Calculator calculator = new Calculator();
        //when
        long result = calculator.add(firstDigit, secondDigit);
        //then
        assertThat(result).isEqualTo(expectedResult);
    }

    private static Stream<Arguments> provideDataForAddMethod() {
        return Stream.of(
                Arguments.of(3, 2, 5),
                Arguments.of(-1, -3, -4),
                Arguments.of(Integer.MAX_VALUE, Integer.MAX_VALUE, 4_294_967_294L)
        );
    }

}